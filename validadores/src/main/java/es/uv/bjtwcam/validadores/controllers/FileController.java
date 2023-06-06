package es.uv.bjtwcam.validadores.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.uv.bjtwcam.productores.domain.File;
import es.uv.bjtwcam.productores.domain.FileSQL;
import es.uv.bjtwcam.productores.services.FileService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/v1/validador/file")
public class FileController {
    
    @Autowired FileService fs;

    public int cuotaAnual = 5;

    //Obtener el listado de ficheros pendientes de revision
    @GetMapping()
    @Operation(summary="Obtener todos los ficheros pendientes", description="Obtener todos los ficheros pendientes de revision")
    public ResponseEntity<List<FileSQL>> getAll() {
        return new ResponseEntity<>(fs.findAllByStatus("Pending to check"), HttpStatus.OK);
    }

    //Preparacion y publicacion de un fichero
    @PutMapping("/{id}")
    @Operation(summary="Preparacion y publicacion de un fichero", description="Preparacion y publicacion de un fichero")
    public ResponseEntity<FileSQL> publishFile(@PathVariable("id") String id) {
        FileSQL f = fs.findSQLFileById(id);
        if (f == null) {
            return ResponseEntity.notFound().build();
        }
        f.setStatus("Published");
        fs.save(f);
        return ResponseEntity.ok(f);
    }
}

