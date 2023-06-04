package es.uv.bjtwcam.validadores.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.uv.bjtwcam.validadores.services.ValidadorService;
import lombok.extern.slf4j.Slf4j;
import es.uv.bjtwcam.productores.domain.Productor;

@RestController
@RequestMapping("/api/v1/validador")
@Slf4j
public class ValidarController {

    @Autowired
    private ValidadorService vs;

    //Obtener listado de productores, si no se indica ningun filtro se devuelven todos
    @GetMapping()
    public List<Productor> getProductores() {
        log.info("Obteniendo productores");
        return this.vs.findAll();
    }

    //Aprobar un nuevo productor
    //Se indicara el identificador del productor
    //Se indicara la cuota anual
    @PutMapping("/aprobar/{id}")
    public ResponseEntity<Productor> aprobarProductor(@PathVariable("id") UUID id) {
        //check if id exists
        Productor p = vs.findById(id);
        if (p == null) {
            log.error("No existe el productor con id: {}", id);
            return ResponseEntity.notFound().build();
        }

        log.debug("Aprobando productor");
        vs.aprobarProductor(p);
        return ResponseEntity.ok(p);
    }
    
    //Modificacion de la informacion de un productor
    //Se podra actualizar cualquier campo del productor a traves de su identificador
    @PutMapping("/{id}")
    public ResponseEntity<Productor> updateProductor(@PathVariable("id") UUID id) {
        //check if id exists
        Productor p = vs.findById(id);
        if (p == null) {
            log.error("No existe el productor con id: {}", id);
            return ResponseEntity.notFound().build();
        }

        log.debug("Actualizando productor");
        vs.updateProductor(p);
        return ResponseEntity.ok(p);
    }

    // Eliminar un productor
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProductor(@PathVariable("id") UUID id) {
        //check if id exists
        Productor p = vs.findById(id);
        if (p == null) {
            log.error("No existe el productor con id: {}", id);
            return ResponseEntity.notFound().build();
        }
        
        log.debug("Eliminando productor");
        vs.deleteProductor(p);
        return ResponseEntity.ok("Productor eliminado");
    }

    // @PutMapping("validador/aprobar/{nif}")
    // public ResponseEntity<Mono<Productor>> aprobarProductor(@PathVariable("nif") String nif) {
    //     //check if id exists
    //     Mono<Productor> p = vs.findByNif(nif);
    //     if (p == null) {
    //         LOGGER.error("No existe el productor con nif: {}", nif);
    //         return ResponseEntity.notFound().build();
    //     }

    //     LOGGER.debug("Aprobando productor");
    //     p.subscribe(productor -> {
    //         vs.aprobarProductor(productor);
    //     });
    //     return ResponseEntity.ok(p);
    // }

    // @PutMapping("validador/{nif}")
    // public ResponseEntity<Mono<Productor>> updateProductor(@PathVariable("nif") String nif) {
    //     //check if id exists
    //     Mono<Productor> p = vs.findByNif(nif);
    //     if (p == null) {
    //         LOGGER.error("No existe el productor con nif: {}", nif);
    //         return ResponseEntity.notFound().build();
    //     }

    //     LOGGER.debug("Actualizando productor");
    //     p.subscribe(productor -> {
    //         vs.updateProductor(productor);
    //     });
    //     return ResponseEntity.ok(p);
    // }

    // @DeleteMapping("validador/{nif}")
    // public ResponseEntity<Mono<String>> deleteProductor(@PathVariable("nif") String nif) {
    //     //check if id exists
    //     Mono<Productor> p = vs.findByNif(nif);
    //     if (p == null) {
    //         LOGGER.error("No existe el productor con nif: {}", nif);
    //         return ResponseEntity.notFound().build();
    //     }
        
    //     LOGGER.debug("Eliminando productor");
    //     p.subscribe(productor -> {
    //         vs.deleteProductor(productor);
    //     });
    //     return ResponseEntity.ok(Mono.just("Productor eliminado"));
    // }

    // @GetMapping("validador/file")
    // public Flux<Productor> getFicheros() {
    //     LOGGER.debug("Obteniendo ficheros");
    //     return this.vs.getFicheros();
    // }

    // @PutMapping("validador/file/{id}")
    // public Flux<Productor> publicarFichero() {
    //     LOGGER.debug("Publicando fichero");
    //     return this.vs.publicarFichero();
    // }
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