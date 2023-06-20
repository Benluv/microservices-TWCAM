package es.uv.bjtwcam.productores.controllers;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.uv.bjtwcam.productores.domain.Productor;
import es.uv.bjtwcam.productores.objects.AuthenticatedProductor;
import es.uv.bjtwcam.productores.objects.ProductorDTO;
import es.uv.bjtwcam.productores.services.AnalyticsService;
import es.uv.bjtwcam.productores.services.ProductorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import org.springframework.security.core.Authentication;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/v1/productor")
public class RegistroController {
    
    @Autowired 
    private ProductorService ps;

    @Autowired
    AnalyticsService as;

    @GetMapping("authenticated")
	@SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary="Obtener productor autenticado", description="Obtener la informacion del productor autenticado")
    public ResponseEntity<AuthenticatedProductor> getAuthenticatedProductor(Authentication auth) {
        log.debug("Obteniendo productor autenticado");
        if(auth.isAuthenticated()) {
            String username = auth.getName();
            AuthenticatedProductor authenticatedProductor = new AuthenticatedProductor(username);
            return new ResponseEntity<>(authenticatedProductor, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
    
    @GetMapping("/{id}")
	@SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary="Obtener productor", description="Obtener la informacion de un productor por su id")
    public String getProductor(@PathVariable(name="id") String id) {
        log.info("getProductor: " + id);
        // Update count of user access
        as.addUserAccess(id);
        return "Se obtiene el productor: "+ id;
    }

    @GetMapping
    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary="Obtener listado de productores", description="Obtener listado de productores, si no se indica ningun filtro se devuelven todos")
    public ResponseEntity<List<Productor>> getProductores(@RequestParam(name = "param", required = false) String param) {
        //check if param matches a Productor field
        if (param != null) {
            //get names from Productor
            Field[] fields = Productor.class.getDeclaredFields();
            List<String> fieldList = Arrays.stream(fields).map(Field::getName).collect(Collectors.toList());
            //check if param matches a Productor field
            for (String field : fieldList) {
                if (param.equals(field)) {
                    log.info("Obteniendo productores por " + param);
                    return new ResponseEntity<List<Productor>>(ps.findAllByField(field, param), HttpStatus.OK);
                }
            }
        }

        log.info("Obteniendo todos los productores");
        return new ResponseEntity<List<Productor>>(ps.findAll(), HttpStatus.OK);
    }


    @PostMapping()
    @Operation(summary="Crear nuevo productor", description="Solicitud de registro de un nuevo productor (No Auth)")
    public ResponseEntity<Productor> createProductor(@RequestBody Productor productor) {
        log.info("creando Productor: " + productor);
        // insert productor into db
        Productor p = ps.insert(productor);
        if (p != null) {
            return new ResponseEntity<Productor>(p, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{id}")
	@SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary="Modificar productor", description="Modificacion de la informacion del productor")
    public String modifyUser(@PathVariable("id") String id, @RequestBody ProductorDTO productor) {
        log.info("modifyUser: " + id);
        // update productor into db
        ps.update(id, productor);
        return "Productor modificado correctamente";
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