package es.uv.bjtwcam.productores.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

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

    @Autowired
    private RestTemplate template;

    @Value("${productores.url}")
    private String api;

    @GetMapping("status")
	public ResponseEntity<String> status(){
		return new ResponseEntity<String>("Running", HttpStatus.OK);
	}

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

    @PostMapping()
    @Operation(summary="Crear nuevo productor", description="Solicitud de registro de un nuevo productor (No Auth)")
    public ResponseEntity<Productor> createProductor(@RequestBody Productor productor) {
        
        ResponseEntity<Productor> response; 
        if(api == null) {
            api = "http://localhost:3307/api/v1/productor";
        }
        log.info("creando Productor: " + productor);
        try {
            response = template.postForEntity(api, productor, Productor.class);
        } catch (ResourceAccessException e) {
            log.error("Error al crear el productor: " + e.getMessage());
            return new ResponseEntity<>(new Productor(), HttpStatus.SERVICE_UNAVAILABLE);
        }
        if (response.getStatusCode() == HttpStatus.CREATED) {
            return new ResponseEntity<Productor>(response.getBody(), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(new Productor(), HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{id}")
	@SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary="Modificar productor", description="Modificacion de la informacion del productor")
    public ResponseEntity<Productor> modifyUser(@PathVariable("id") String id, @RequestBody ProductorDTO productor) {
        
        Productor response;
        if(api == null) {
            api = "http://localhost:3307/api/v1/productor";
        }
        try {
            response = template.patchForObject(api + id, productor, Productor.class);
        } catch (ResourceAccessException e) {
            log.error("Error al modificar el productor: " + e.getMessage());
            return new ResponseEntity<>(new Productor(), HttpStatus.SERVICE_UNAVAILABLE);
        } 
        if (response != null) {
            return new ResponseEntity<Productor>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(new Productor(), HttpStatus.BAD_REQUEST);

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