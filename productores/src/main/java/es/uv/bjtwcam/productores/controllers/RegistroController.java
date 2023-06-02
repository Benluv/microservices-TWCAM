package es.uv.bjtwcam.productores.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.uv.bjtwcam.productores.objects.ProductorDTO;
import es.uv.bjtwcam.productores.services.AnalyticsService;
import es.uv.bjtwcam.productores.services.ProductorService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/productor")
@Slf4j
public class RegistroController {
    
    @Autowired 
    private ProductorService ps;

    @Autowired
    AnalyticsService analyticsService;

    @GetMapping("/{id}")
    @Operation(summary="Obtener productor", description="Obtener la informacion de un productor por su id")
    public String getProductor(@PathVariable(name="id") String id) {
        log.info("getProductor: " + id);
        // Update count of user access
        analyticsService.addUserAccess(id);
        return "Se obtiene el productor: "+ id;
    }

    @PostMapping()
    @Operation(summary="Crear nuevo productor", description="Solicitud de registro de un nuevo productor (No Auth)")
    public String createProductor(@RequestBody ProductorDTO productor) {
        log.info("createProductor: " + productor);
        // insert productor into db
        ps.insert(productor);
        return "Se crea el productor: "+ productor;
    }

    @PutMapping("/{id}")
    @Operation(summary="Modificar productor", description="Modificacion de la informacion del productor")
    public String modifyUser(@PathVariable("id") String id, @RequestBody ProductorDTO productor) {
        log.info("modifyUser: " + id);
        // update productor into db
        ps.update(id, productor);
        return "Productor modificado correctamente";
    }

    // @PostMapping("productor")
    // @Operation(summary="Crear nuevo productor", description="Solicitud de registro de un nuevo productor (No Auth)")
    // public Mono<Productor> createProductor(@RequestBody Productor productor) {
    //     LOGGER.debug("Creando productor: {}", productor);
    //     return this.ps.createProductor(productor);
    // }

    // @PutMapping("productor")
    // @Operation(summary="Modificar productor", description="Modificacion de la informacion del productor")
    // public Mono<Productor> updateProductor(@RequestBody Productor productor) {
    //     LOGGER.debug("Actualizando productor: {}", productor);
    //     return this.ps.updateProductor(productor);
    // }

    // @PostMapping("productor/file")
    // @Operation(summary="Subir fichero", description="Subir un fichero de datos")
    // public Mono<Productor> uploadFile(@RequestBody Productor productor) {
    //     LOGGER.debug("Subiendo fichero: {}", productor);
    //     return this.ps.uploadFile(productor);
    // }

    // @GetMapping("productor")
    // @Operation(summary="Listar ficheros", description="Consultar el listado de ficheros de datos del productor")
    // public Flux<Productor> getProductores() {
    //     LOGGER.debug("Obteniendo productores");
    //     return this.ps.getProductores();
    // }

    // @PutMapping("productor/file/{id}")
    // @Operation(summary="Modificar fichero", description="Modificar la informacion de un fichero de datos del productor")
    // public Mono<Productor> updateFile(@RequestBody Productor productor) {
    //     LOGGER.debug("Actualizando fichero: {}", productor);
    //     return this.ps.updateFile(productor);
    // }

    // @DeleteMapping("productor/file/{id}")
    // @Operation(summary="Eliminar fichero", description="Eliminar un fichero de datos del productor")
    // public Mono<Productor> deleteFile(@RequestBody Productor productor) {
    //     LOGGER.debug("Eliminando fichero: {}", productor);
    //     return this.ps.deleteFile(productor);
    // }
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