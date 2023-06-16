package es.uv.bjtwcam.validadores.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.uv.bjtwcam.validadores.services.ValidadorService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import es.uv.bjtwcam.productores.domain.Productor;

@RestController
@RequestMapping("/api/v1/validador")
@Slf4j
public class ValidarController {

    @Autowired
    private ValidadorService vs;

    @GetMapping
    @Operation(summary="Obtener listado de productores", description="Obtener listado de productores, si no se indica ningun filtro se devuelven todos")
    public ResponseEntity<List<Productor>> getProductores(
        @RequestParam(name = "id", required = false) String id,
        @RequestParam(name = "nif", required = false) String nif,
        @RequestParam(name = "name", required = false) String name,
        @RequestParam(name = "email", required = false) String email,
        @RequestParam(name = "type", required = false) String type,
        @RequestParam(name = "estado", required = false) String estado,
        @RequestParam(name = "cuota", required = false) String cuota
    ) {
        List<Productor> p = new ArrayList<Productor>();

        //Filtrar por id
        if (!id.isBlank()) {
            UUID id_ = null;
            try {
                log.info("Obteniendo productor con id: {}", id);
                id_ = UUID.fromString(id);
                if (p.add(vs.findById(id_))) {
                    return new ResponseEntity<List<Productor>>(p, HttpStatus.OK);
                } else {
                    log.error("No existe el productor con id: {}", id);
                    return ResponseEntity.notFound().build();
                }
            } catch (IllegalArgumentException e) {
                log.error("El id no es un UUID valido: {}", id);
                return ResponseEntity.badRequest().build();
            }
        }

        //Filtrar por nif
        else if (!nif.isBlank()) {
            log.info("Obteniendo productor con nif: {}", nif);
            if (p.add(vs.findByNif(nif))) {
                return new ResponseEntity<List<Productor>>(p, HttpStatus.OK);
            } else {
                log.error("No existe el productor con nif: {}", nif);
                return ResponseEntity.notFound().build();
            }
        }

        //Filtrar por name
        else if (!name.isBlank()) {
            log.info("Obteniendo productor con name: {}", name);
            if (p.add(vs.findByName(name))) {
                return new ResponseEntity<List<Productor>>(p, HttpStatus.OK);
            } else {
                log.error("No existe el productor con name: {}", name);
                return ResponseEntity.notFound().build();
            }
        }

        //Filtrar por email
        else if (!email.isBlank()) {
            log.info("Obteniendo productor con email: {}", email);
            if (p.add(vs.findByEmail(email))) {
                return new ResponseEntity<List<Productor>>(p, HttpStatus.OK);
            } else {
                log.error("No existe el productor con email: {}", email);
                return ResponseEntity.notFound().build();
            }
        }

        //Filtrar por type
        else if (!type.isBlank()) {
            log.info("Obteniendo productor con type: {}", type);
            if (p.add(vs.findByType(type))) {
                return new ResponseEntity<List<Productor>>(p, HttpStatus.OK);
            } else {
                log.error("No existe el productor con type: {}", type);
                return ResponseEntity.notFound().build();
            }
        }

        //Filtrar por estado
        else if (!estado.isBlank()) {
            log.info("Obteniendo productor con estado: {}", estado);
            if (p.add(vs.findByEstado(estado))) {
                return new ResponseEntity<List<Productor>>(p, HttpStatus.OK);
            } else {
                log.error("No existe el productor con estado: {}", estado);
                return ResponseEntity.notFound().build();
            }
        }

        //Filtrar por cuota
        else if (!cuota.isBlank()) {
            log.info("Obteniendo productor con cuota: {}", cuota);
            if (p.add(vs.findByCuotaAnual(cuota))) {
                return new ResponseEntity<List<Productor>>(p, HttpStatus.OK);
            } else {
                log.error("No existe el productor con cuota: {}", cuota);
                return ResponseEntity.notFound().build();
            }
        }
        
        //Si no se indica ningun filtro se devuelven todos
        else {
            log.info("Obteniendo todos los productores");
            p =  this.vs.findAll();
            return new ResponseEntity<List<Productor>>(p, HttpStatus.OK);
        }
    }

    @PutMapping("/aprobar/{id}")
    @Operation(summary="Aprobar un nuevo productor", description="Se indicara el identificador del productor y la cuota anual")
    public ResponseEntity<Productor> aprobarProductor(
        @PathVariable("id") UUID id,
        @RequestParam(name = "cuota", required = true) String cuotaAnual
        ) {
        //check if id exists
        Productor p = vs.findById(id);
        Integer cuota = 0;
        if (p == null) {
            log.error("No existe el productor con id: {}", id);
            return ResponseEntity.notFound().build();
        }
        //check if cuota is a float
        try {
            cuota = Integer.parseInt(cuotaAnual);
        } catch (NumberFormatException e) {
            log.error("La cuota no es un numero valido: {}", cuotaAnual);
            return ResponseEntity.badRequest().build();
        }

        log.debug("Aprobando productor");
        vs.aprobarProductor(p);
        p.setCuota(cuota);
        vs.updateProductor(p);
        return ResponseEntity.ok(p);
    }
    
    @PutMapping("/{id}")
    @Operation(summary="Modificar productor", description="Modificacion de la informacion del productor.Se podra actualizar cualquier campo del productor a traves de su identificador")
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

    @DeleteMapping("/{id}")
    @Operation(summary="Eliminar un productor", description="Se indicara el identificador del productor a eliminar")
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