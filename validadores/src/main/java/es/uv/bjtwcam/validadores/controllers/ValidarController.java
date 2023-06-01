package es.uv.bjtwcam.validadores.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.uv.bjtwcam.validadores.services.ValidadorService;
import es.uv.bjtwcam.productores.domain.Productor;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/v1")
public class ValidarController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ValidarController.class);

    @Autowired
    private ValidadorService vs;

    @GetMapping("validador")
    public Flux<Productor> getProductores() {
        LOGGER.debug("Obteniendo productores");
        return this.vs.getProductores();
    }

    @PutMapping("validador/aprobar/{id}")
    public Flux<Productor> aprobarProductor() {
        LOGGER.debug("Aprobando productor");
        return this.vs.aprobarProductor();
    }

    @PutMapping("validador/{id}")
    public Flux<Productor> updateProductor() {
        LOGGER.debug("Actualizando productor");
        return this.vs.updateProductor();
    }

    @DeleteMapping("validador/{id}")
    public Flux<Productor> deleteProductor() {
        LOGGER.debug("Eliminando productor");
        return this.vs.deleteProductor();
    }

    @GetMapping("validador/file")
    public Flux<Productor> getFicheros() {
        LOGGER.debug("Obteniendo ficheros");
        return this.vs.getFicheros();
    }

    @PutMapping("validador/file/{id}")
    public Flux<Productor> publicarFichero() {
        LOGGER.debug("Publicando fichero");
        return this.vs.publicarFichero();
    }
}

/*
 * Validadores:

Obtener el listado de productores
GET http://127.0.0.1:puerto/api/v1/validador

Aprobar un nuevo productor
PUT http://127.0.0.1:puerto/api/v1/validador/aprobar/{id}

Modificacion de la informacion de un productor
PUT http://127.0.0.1:puerto/api/v1/validador/{id}

Eliminar un productor
DELETE http://127.0.0.1:puerto/api/v1/validador/{id}

Obtener el listado de ficheros pendientes de revision
GET http://127.0.0.1:puerto/api/v1/validador/file

Preparacion y publicacion de un fichero
PUT http://127.0.0.1:puerto/api/v1/validador/file/{id}

 */