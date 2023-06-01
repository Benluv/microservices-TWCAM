package es.uv.bjtwcam.productores.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.uv.bjtwcam.productores.domain.Productor;
import es.uv.bjtwcam.productores.services.ProductorService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1")
public class RegistroController {
    private static final Logger LOGGER = LoggerFactory.getLogger(RegistroController.class);
    
    @Autowired 
    private ProductorService ps;

    @PostMapping("productor")
    public Mono<Productor> createProductor(@RequestBody Productor productor) {
        LOGGER.debug("Creando productor: {}", productor);
        return this.ps.createProductor(productor);
    }

    @PutMapping("productor")
    public Mono<Productor> updateProductor(@RequestBody Productor productor) {
        LOGGER.debug("Actualizando productor: {}", productor);
        return this.ps.updateProductor(productor);
    }

    @PostMapping("productor/file")
    public Mono<Productor> uploadFile(@RequestBody Productor productor) {
        LOGGER.debug("Subiendo fichero: {}", productor);
        return this.ps.uploadFile(productor);
    }

    @GetMapping("productor")
    public Flux<Productor> getProductores() {
        LOGGER.debug("Obteniendo productores");
        return this.ps.getProductores();
    }

    @PutMapping("productor/file/{id}")
    public Mono<Productor> updateFile(@RequestBody Productor productor) {
        LOGGER.debug("Actualizando fichero: {}", productor);
        return this.ps.updateFile(productor);
    }

    @DeleteMapping("productor/file/{id}")
    public Mono<Productor> deleteFile(@RequestBody Productor productor) {
        LOGGER.debug("Eliminando fichero: {}", productor);
        return this.ps.deleteFile(productor);
    }
}

/*
--------------------------- PRODUCTORES ---------------------------
Solicitud de registro de un nuevo productor (No Auth)
POST http://127.0.0.1:puerto/api/v1/productor

Modificacion de la informacion del productor
PUT http://127.0.0.1:puerto/api/v1/productor

Subir un fichero de datos
POST http://127.0.0.1:puerto/api/v1/productor/file

Consultar el listado de ficheros de datos del productor
GET http://127.0.0.1:puerto/api/v1/productor

Modificar la informacion de un fichero de datos del productor
PUT http://127.0.0.1:puerto/api/v1/productor/file/{id}

Eliminar un fichero de datos del productor
DELETE http://127.0.0.1:puerto/api/v1/productor/file/{id}

*/