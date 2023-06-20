package es.uv.bjtwcam.consumidores.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

import es.uv.bjtwcam.consumidores.services.ConsumidorService;
import es.uv.bjtwcam.productores.domain.Productor;

@RestController
@RequestMapping("/api/v1")
public class ConsultarController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConsultarController.class);

    @Autowired
    private ConsumidorService cs;

    @GetMapping("consumidor/file/{palabra clave}")
    public Optional<Productor> getFileByWord() {
        LOGGER.debug("Obteniendo productores");
        return this.cs.getFileByWord();
    }

    @GetMapping("consumidor/{nombre productor}")
    public Optional<Productor> getFileByProd() {
        LOGGER.debug("Obteniendo productores");
        return this.cs.getFileByProd();
    }

    @GetMapping("consumidor/file/{id}?full=false")
    public Optional<Productor> getPrevFile() {
        LOGGER.debug("Obteniendo previsualizacion de fichero");
        return this.cs.getPrevFile();
    }

    @GetMapping("consumidor/file/{id}?full=true")
    public Optional<Productor> getFile() {
        LOGGER.debug("Obteniendo fichero completo");
        return this.cs.getFile();
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