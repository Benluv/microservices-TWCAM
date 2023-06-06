package es.uv.bjtwcam.consumidores.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.uv.bjtwcam.consumidores.services.ConsumidorService;
import es.uv.bjtwcam.productores.domain.File;
import es.uv.bjtwcam.productores.domain.FileSQL;
import es.uv.bjtwcam.productores.domain.Productor;

@RestController
@RequestMapping("/api/v1/consumidor")
public class ConsultarController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConsultarController.class);

    @Autowired
    private ConsumidorService cs;
    /*
    Obtener listado ordenado de ficheros por palabra clave
    Ficheros con estado publicado
    Ordernar por: 
    fecha de creacion (de mas reciente a mas antiguo)
    tamano (mas grande a mas pequeno)
    numero de descargas (de mas a menos)
    numero de visualizaciones (de mas a menos)
    Se obtendra: 
    identificador del fichero, 
    titulo, 
    descripcion, 
    nombre del productor, 
    fehca de creacion, 
    formato, 
    tamano, 
    numero de previsualizaciones y 
    descargas
    */
    @GetMapping("/file/{palabra clave}")
    public ResponseEntity<List<?>> getFileByWord() {
        LOGGER.debug("Obteniendo productores");
        // return this.cs.getFileByWord();
        return null;
    }

    //Obtener listado de ficheros por nombre de productor
    //Solo publicados
    //Se indicara el nombre o razon social del productor
    //se obtiene el mismo resultado que en el anterior
    @GetMapping("/{name}")
    public ResponseEntity<FileSQL> getFileByProd() {
        LOGGER.debug("Obteniendo productores");
        // return this.cs.getFileByProd();
        return null;
    }

    //Obtener una previsualizacion de un fichero
    //se proporcionara el identificador de un fichero publicado
    //primeras 10 observaciones del fichero
    //se incrementa el numero de previsualizaciones del fichero.
    @GetMapping("/file/{id}?full=false")
    public ResponseEntity<?> getPrevFile() {
        LOGGER.debug("Obteniendo previsualizacion de fichero");
        // return this.cs.getPrevFile();
        return null;
    }

    //Obtener un fichero completo
    //se proporcionara el identificador de un fichero publicado
    //se incrementa el numero de descargas del fichero.
    @GetMapping("/file/{id}?full=true")
    public ResponseEntity<File> getFile() {
        LOGGER.debug("Obteniendo fichero completo");
        // return this.cs.getFile();
        return null;
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