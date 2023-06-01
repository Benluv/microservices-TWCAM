package es.uv.bjtwcam.validadores.controllers;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.uv.bjtwcam.validadores.services.ValidadorService;
import es.uv.bjtwcam.productores.domain.Productor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1")
public class ValidarController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ValidarController.class);

    @Autowired
    private ValidadorService vs;

    @GetMapping("validador")
    public Flux<Productor> getProductores() {
        LOGGER.debug("Obteniendo productores");
        return this.vs.findAll();
    }

    @PutMapping("validador/aprobar/{id}")
    public ResponseEntity<Mono<Productor>> aprobarProductor(@PathVariable("id") String id) {
        UUID id_ = null;
        //check if id is valid UUID
        try {
            LOGGER.info("Buscando productor por id: {}", id);
            id_ = UUID.fromString(id);
        } catch (IllegalArgumentException e) {
            LOGGER.error("Error al convertir el id a UUID");
            return ResponseEntity.badRequest().build();
        }
        //check if id exists
        if (vs.findById(id_).block() == null) {
            LOGGER.error("No existe el productor con id: {}", id);
            return ResponseEntity.notFound().build();
        }

        LOGGER.debug("Aprobando productor");
        Mono<Productor> p = vs.findById(id_);
        p.subscribe(productor -> {
            productor.setApproved();
            vs.aprobarProductor(productor);
        });
        return ResponseEntity.ok(p);
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