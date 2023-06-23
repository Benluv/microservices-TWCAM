package es.uv.bjtwcam.mysql.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.uv.bjtwcam.mysql.domain.Productor;
import es.uv.bjtwcam.mysql.services.ProductorService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;


@RequestMapping("/api/v1/validador")
@Slf4j
public class ValidarController {

    @Autowired
    private ProductorService ps;

    @Value("${validador.productor.url}")
    private String api;
    
	@GetMapping("status")
	public ResponseEntity<String> test(){
		return new ResponseEntity<String>("Running", HttpStatus.OK);
	}

    @GetMapping({"/{id}"})
    @Operation(summary="Obtener productor", description="Obtener la informacion de un productor por su id")
    public ResponseEntity<Productor> getProductor(@PathVariable(name="id") String id) {
        
            try {
                log.info("Obteniendo productor con id: {}", id);
                Productor p = ps.findById(id);
                if (p != null) {
                    return new ResponseEntity<Productor>(p, HttpStatus.OK);
                } else {
                    log.error("No existe el productor con id: {}", id);
                    return new ResponseEntity<Productor>(p, HttpStatus.NOT_FOUND);
                }
            } catch (IllegalArgumentException e) {
                log.error("El id no es un UUID valido: {}", id);
                return new ResponseEntity<Productor>(HttpStatus.BAD_REQUEST);
            }
    }

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

        //check if no parameters are passed
        if (id.isBlank() && nif.isBlank() && name.isBlank() && email.isBlank() && type.isBlank() && estado.isBlank() && cuota.isBlank()) {
            log.info("Obteniendo todos los productores");
            p =  this.ps.findAll();
            return new ResponseEntity<List<Productor>>(p, HttpStatus.OK);
        }

        //Filtrar por id
        if (!id.isBlank()) {
            try {
                log.info("Obteniendo productor con id: {}", id);
                if (p.add(ps.findById(id))) {
                    return new ResponseEntity<List<Productor>>(p, HttpStatus.OK);
                } else {
                    log.error("No existe el productor con id: {}", id);
                    return new ResponseEntity<List<Productor>>(p, HttpStatus.NOT_FOUND);
                }
            } catch (IllegalArgumentException e) {
                log.error("El id no es un UUID valido: {}", id);
                return new ResponseEntity<List<Productor>>(p, HttpStatus.BAD_REQUEST);
            }
        }

        //Filtrar por nif
        else if (!nif.isBlank()) {
            log.info("Obteniendo productor con nif: {}", nif);
            Productor byNif = ps.findByNif(nif);
            if (byNif != null) {
                p.add(byNif);
            } else {
                log.error("No existe el productor con nif: {}", nif);
                return ResponseEntity.notFound().build();
            }
        }

        //Filtrar por name
        else if (!name.isBlank()) {
            log.info("Obteniendo productor con name: {}", name);
            List<Productor> byName = ps.findAllByNombre(name);
            if (byName != null) {
                p.addAll(byName);
            } else {
                log.error("No existe el productor con name: {}", name);
                return ResponseEntity.notFound().build();
            }
        }

        //Filtrar por email
        else if (!email.isBlank()) {
            log.info("Obteniendo productor con email: {}", email);
            Productor byEmail = ps.findByEmail(email);
            if (byEmail != null) {
                p.add(byEmail);
                return new ResponseEntity<List<Productor>>(p, null, HttpStatus.OK);
            } else {
                log.error("No existe el productor con email: {}", email);
                return ResponseEntity.notFound().build();
            }
        }

        //Filtrar por type
        else if (!type.isBlank()) {
            log.info("Obteniendo productor con type: {}", type);
            List<Productor> byType = ps.findAllByTipo(type);
            if (byType != null) {
                p.addAll(byType);
            } else {
                log.error("No existe el productor con type: {}", type);
                return ResponseEntity.notFound().build();
            }
        }

        //Filtrar por estado
        else if (!estado.isBlank()) {
            log.info("Obteniendo productor con estado: {}", estado);
            List<Productor> byEstado = ps.findAllByEstado(estado);
            if (byEstado != null) {
                p.addAll(byEstado);
            } else {
                log.error("No existe el productor con estado: {}", estado);
                return ResponseEntity.notFound().build();
            }
        }

        //Filtrar por cuota
        else if (!cuota.isBlank()) {
            log.info("Obteniendo productor con cuota: {}", cuota);
            List<Productor> byCuota = ps.findAllByCuota(cuota);
            if (byCuota != null) {
                p.addAll(byCuota);
            } else {
                log.error("No existe el productor con cuota: {}", cuota);
                return ResponseEntity.notFound().build();
            }
        }
        
        return new ResponseEntity<List<Productor>>(p, HttpStatus.OK);
    }

    @PutMapping("/aprobar/{id}")
    @Operation(summary="Aprobar un nuevo productor", description="Se indicara el identificador del productor y la cuota anual")
    public ResponseEntity<Productor> aprobarProductor(
        @PathVariable("id") String id,
        @RequestParam(name = "cuota", required = true) String cuotaAnual
        ) {
        //check if id exists
        Productor p = ps.findById(id);
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
        ps.aprobarProductor(p);
        p.setCuota(cuota);
        ps.update(id, p);
        return ResponseEntity.ok(p);
    }
    
    @PutMapping("/{id}")
    @Operation(summary="Modificar productor", description="Modificacion de la informacion del productor.Se podra actualizar cualquier campo del productor a traves de su identificador")
    public ResponseEntity<Productor> updateProductor(@PathVariable("id") String id) {
        //check if id exists
        Productor p = ps.findById(id);
        if (p == null) {
            log.error("No existe el productor con id: {}", id);
            return ResponseEntity.notFound().build();
        }

        log.debug("Actualizando productor");
        try {
            ps.update(id, p);
        } catch (Exception e) {
            log.error("Error al actualizar el productor con id: {}", id);
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(p);
    }

    @DeleteMapping("/{id}")
    @Operation(summary="Eliminar un productor", description="Se indicara el identificador del productor a eliminar")
    public ResponseEntity<String> deleteProductor(@PathVariable("id") String id) {
        //check if id exists
        Productor p = ps.findById(id);
        if (p == null) {
            log.error("No existe el productor con id: {}", id);
            return ResponseEntity.notFound().build();
        }
        
        log.debug("Eliminando productor");
        ps.delete(id);
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