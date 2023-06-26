package es.uv.bjtwcam.consumidores.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.uv.bjtwcam.consumidores.objects.FileMongoDTO;
import es.uv.bjtwcam.consumidores.objects.FileSqlDTO;

@RestController
@RequestMapping("/api/v1/consumidor")
public class ConsultarController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConsultarController.class);

    @GetMapping("file/{palabra clave}")
    public ResponseEntity<FileSqlDTO> getFileByWord() {
        LOGGER.debug("Obteniendo productores");
        return new ResponseEntity<FileSqlDTO>(new FileSqlDTO(),HttpStatus.NOT_IMPLEMENTED);
    }

    @GetMapping("{nombre productor}")
    public ResponseEntity<FileSqlDTO> getFileByProd() {
        LOGGER.debug("Obteniendo productores");
        return new ResponseEntity<FileSqlDTO>(new FileSqlDTO(),HttpStatus.NOT_IMPLEMENTED);
    }

    @GetMapping("file/{id}?full=false")
    public ResponseEntity<FileMongoDTO> getPrevFile() {
        LOGGER.debug("Obteniendo previsualizacion de fichero");
        return new ResponseEntity<FileMongoDTO>(new FileMongoDTO(),HttpStatus.NOT_IMPLEMENTED);
    }

    @GetMapping("file/{id}?full=true")
    public ResponseEntity<FileMongoDTO> getFile() {
        LOGGER.debug("Obteniendo fichero completo");
        return new ResponseEntity<FileMongoDTO>(new FileMongoDTO(),HttpStatus.NOT_IMPLEMENTED);
    }
}

/*
 * Consumidores
Obtener listado ordenado de ficheros por palabra clave
GET http://127.0.0.1:puerto/api/v1/consumidor/file/{palabra clave}

Obtener listado de ficheros por nombre de productor
GET http://127.0.0.1:puerto/api/v1/consumidor/{nombre productor}

Obtener una previsualizacion de un fichero
GET http://127.0.0.1:puerto/api/v1/consumidor/file/{id}?full=false

Obtener un fichero completo
GET http://127.0.0.1:puerto/api/v1/consumidor/file/{id}?full=true

 */