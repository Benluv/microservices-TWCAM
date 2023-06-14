package es.uv.bjtwcam.productores.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.uv.bjtwcam.productores.domain.Productor;
import es.uv.bjtwcam.productores.services.ProductorService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/v1")
public class RegistroController {
    private static final Logger LOGGER = LoggerFactory.getLogger(RegistroController.class);
    
    @Autowired 
    private ProductorService ps;

    @PostMapping("productor")
    @Operation(summary="Crear nuevo productor", description="Solicitud de registro de un nuevo productor (No Auth)")
    public ResponseEntity<Productor> createProductor(@RequestBody Productor productor) {
        LOGGER.debug("Creando productor: {}", productor);
        return ResponseEntity.ok(this.ps.createProductor(productor));
    }

    @PutMapping("productor")
    @Operation(summary="Modificar productor", description="Modificacion de la informacion del productor")
    public ResponseEntity<Productor> updateProductor(@RequestBody Productor productor) {
        LOGGER.debug("Actualizando productor: {}", productor);
        return new ResponseEntity<Productor>(this.ps.updateProductor(productor), HttpStatus.OK);
    }

    @PostMapping("productor/file")
    @Operation(summary="Subir fichero", description="Subir un fichero de datos")
    public ResponseEntity<Productor> uploadFile(@RequestBody Productor productor) {
        LOGGER.debug("Subiendo fichero: {}", productor);
        return new ResponseEntity<Productor>(this.ps.uploadFile(productor), HttpStatus.OK);
    }

    @GetMapping("productor")
    @Operation(summary="Listar ficheros", description="Consultar el listado de ficheros de datos del productor")
    public ResponseEntity<Productor> getProductores() {
        LOGGER.debug("Obteniendo productores");
        return new ResponseEntity<Productor>(this.ps.getProductores(), HttpStatus.OK);
    }

    @PutMapping("productor/file/{id}")
    @Operation(summary="Modificar fichero", description="Modificar la informacion de un fichero de datos del productor")
    public ResponseEntity<Productor> updateFile(@RequestBody Productor productor) {
        LOGGER.debug("Actualizando fichero: {}", productor);
        return new ResponseEntity<Productor>(this.ps.updateFile(productor), HttpStatus.OK);
    }

    @DeleteMapping("productor/file/{id}")
    @Operation(summary="Eliminar fichero", description="Eliminar un fichero de datos del productor")
    public ResponseEntity<Productor> deleteFile(@RequestBody Productor productor) {
        LOGGER.debug("Eliminando fichero: {}", productor);
        return new ResponseEntity<Productor>(this.ps.deleteFile(productor), HttpStatus.OK);
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