package es.uv.bjtwcam.validadores.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import es.uv.bjtwcam.validadores.objects.ProductorDTO;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/validador")
@Slf4j
public class ValidarController {

	@Autowired
    private RestTemplate template;

    @Value("${validador.productor.url}")
    private String api;
    
	@GetMapping("status")
	public ResponseEntity<String> test(){
		return new ResponseEntity<String>("Running", HttpStatus.OK);
	}

    @GetMapping({"/{id}"})
    @Operation(summary="Obtener productor", description="Obtener la informacion de un productor por su id")
    public ResponseEntity<ProductorDTO> getProductor(@PathVariable(name="id") String id) {
		ResponseEntity<ProductorDTO> response; 
        if(api == null) {
            api = "http://localhost:8080/api/v1/productor";
        }
        try {
            response = template.getForEntity(api+"/"+ id, ProductorDTO.class);
        } 
        catch (ResourceAccessException e) {
            return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
        }
        if(response.getStatusCode() == HttpStatus.OK) {
            log.info("Obteniendo productor con id: {}", id);
            return new ResponseEntity<ProductorDTO>(response.getBody(), HttpStatus.OK);
        } else {
            log.error("No existe el productor con id: {}", id);
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    @Operation(summary="Obtener listado de productores", description="Obtener listado de productores, si no se indica ningun filtro se devuelven todos")
    public ResponseEntity<List<ProductorDTO>> getProductores(
        @RequestParam(name = "id", required = false) String id,
        @RequestParam(name = "nif", required = false) String nif,
        @RequestParam(name = "name", required = false) String name,
        @RequestParam(name = "email", required = false) String email,
        @RequestParam(name = "type", required = false) String type,
        @RequestParam(name = "estado", required = false) String estado,
        @RequestParam(name = "cuota", required = false) String cuota
    ) {
        List<ProductorDTO> p = new ArrayList<ProductorDTO>();
		ResponseEntity<List<ProductorDTO>> response; 
        if(api == null) {
            api = "http://localhost:8080/api/v1/productor";
        }

        //check if no parameters are passed
        if (id.isBlank() && nif.isBlank() && name.isBlank() && email.isBlank() && type.isBlank() && estado.isBlank() && cuota.isBlank()) {
            log.info("Obteniendo todos los productores");
            try {
                response = template.exchange(
                    api,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<ProductorDTO>>(){}
                );
            } 
            catch (ResourceAccessException e) {
                return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
            }
            if(response.getStatusCode() == HttpStatus.OK) {
                return new ResponseEntity<List<ProductorDTO>>(response.getBody(), HttpStatus.OK);
            } else {
                return new ResponseEntity<List<ProductorDTO>>(response.getBody(), HttpStatus.BAD_REQUEST);
            }
        }

        //Filtrar por id
        if (!id.isBlank()) {
            try {
                response = template.exchange(
                    api+"/"+ id,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<ProductorDTO>>(){}
                );
            } 
            catch (ResourceAccessException e) {
                return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
            }
            if(response.getStatusCode().is2xxSuccessful()) {
                log.info("Obteniendo productor con id: {}", id);
                return new ResponseEntity<List<ProductorDTO>>(response.getBody(), HttpStatus.OK);
            } else {
                log.error("No existe el productor con id: {}", id);
                return new ResponseEntity<List<ProductorDTO>>(response.getBody(), HttpStatus.NOT_FOUND);
            }
        }

        //Filtrar por nif
        else if (!nif.isBlank()) {
            try {
                response = template.exchange(
                    api+"?nif="+ nif,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<ProductorDTO>>(){}
                );
            } 
            catch (ResourceAccessException e) {
                return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
            }
            if(response.getStatusCode().is2xxSuccessful()) {
                log.info("Obteniendo productor con id: {}", id);
                return new ResponseEntity<List<ProductorDTO>>(response.getBody(), HttpStatus.OK);
            } else {
                log.error("No existe el productor con id: {}", id);
                return new ResponseEntity<List<ProductorDTO>>(response.getBody(), HttpStatus.NOT_FOUND);
            }
        }

        //Filtrar por name
        else if (!name.isBlank()) {
            try {
                response = template.exchange(
                    api+"?name="+ name,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<ProductorDTO>>(){}
                );
            } 
            catch (ResourceAccessException e) {
                return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
            }
            if(response.getStatusCode().is2xxSuccessful()) {
                log.info("Obteniendo productor con id: {}", id);
                p.addAll(response.getBody());
            } else {
                log.error("No existe el productor con id: {}", id);
                return new ResponseEntity<List<ProductorDTO>>(response.getBody(), HttpStatus.NOT_FOUND);
            }
        }

        //Filtrar por email
        else if (!email.isBlank()) {
            try {
                response = template.exchange(
                    api+"?email="+ email,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<ProductorDTO>>(){}
                );
            } 
            catch (ResourceAccessException e) {
                return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
            }
            if(response.getStatusCode().is2xxSuccessful()) {
                log.info("Obteniendo productor con id: {}", id);
                return new ResponseEntity<List<ProductorDTO>>(response.getBody(), HttpStatus.OK);
            } else {
                log.error("No existe el productor con id: {}", id);
                return new ResponseEntity<List<ProductorDTO>>(response.getBody(), HttpStatus.NOT_FOUND);
            }
        }

        //Filtrar por type
        else if (!type.isBlank()) {
            try {
                response = template.exchange(
                    api+"?type="+ type,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<ProductorDTO>>(){}
                );
            } 
            catch (ResourceAccessException e) {
                return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
            }
            if(response.getStatusCode().is2xxSuccessful()) {
                log.info("Obteniendo productor con id: {}", id);
                p.addAll(response.getBody());
            } else {
                log.error("No existe el productor con id: {}", id);
                return new ResponseEntity<List<ProductorDTO>>(response.getBody(), HttpStatus.NOT_FOUND);
            }
        }

        //Filtrar por estado
        else if (!estado.isBlank()) {
            try {
                response = template.exchange(
                    api+"?estado="+ estado,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<ProductorDTO>>(){}
                );
            } 
            catch (ResourceAccessException e) {
                return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
            }
            if(response.getStatusCode().is2xxSuccessful()) {
                log.info("Obteniendo productor con id: {}", id);
                p.addAll(response.getBody());
            } else {
                log.error("No existe el productor con id: {}", id);
                return new ResponseEntity<List<ProductorDTO>>(response.getBody(), HttpStatus.NOT_FOUND);
            }
        }

        //Filtrar por cuota
        else if (!cuota.isBlank()) {
            try {
                response = template.exchange(
                    api+"?cuota="+ cuota,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<ProductorDTO>>(){}
                );
            } 
            catch (ResourceAccessException e) {
                return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
            }
            if(response.getStatusCode().is2xxSuccessful()) {
                log.info("Obteniendo productor con id: {}", id);
                p.addAll(response.getBody());
            } else {
                log.error("No existe el productor con id: {}", id);
                return new ResponseEntity<List<ProductorDTO>>(response.getBody(), HttpStatus.NOT_FOUND);
            }
        }
        
        return new ResponseEntity<List<ProductorDTO>>(p, HttpStatus.OK);
    }

    @PutMapping("/aprobar/{id}")
    @Operation(summary="Aprobar un nuevo productor", description="Se indicara el identificador del productor y la cuota anual")
    public ResponseEntity<ProductorDTO> aprobarProductor(
        @PathVariable("id") String id,
        @RequestParam(name = "cuota", required = true) String cuotaAnual
        ) {
            
        if(api == null) {
            api = "http://localhost:8080/api/v1/productor/aprobar";
        }
        ResponseEntity<ProductorDTO> response;    
        log.info("Aprobando productor");
        try {
            response = template.exchange(
                api + "/" + id + "?cuota=" + cuotaAnual,
                HttpMethod.PUT,
                null,
                new ParameterizedTypeReference<ProductorDTO>(){}
            );
        } catch (ResourceAccessException e) {
            return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
        }
        if(response.getStatusCode().is2xxSuccessful()) {
            return new ResponseEntity<ProductorDTO>(response.getBody(), HttpStatus.OK);
        } else {
            return new ResponseEntity<ProductorDTO>(response.getBody(), HttpStatus.BAD_REQUEST);
        }
    }
    
    @PutMapping("/{id}")
    @Operation(summary="Modificar productor", description="Modificacion de la informacion del productor.Se podra actualizar cualquier campo del productor a traves de su identificador")
    public ResponseEntity<ProductorDTO> updateProductor(@PathVariable("id") String id) {
        if(api == null) {
            api = "http://localhost:8080/api/v1/productor";
        }
        ResponseEntity<ProductorDTO> response;
        log.info("Actualizando productor");
        try {
            response = template.exchange(
                api + "/" + id,
                HttpMethod.PUT,
                null,
                new ParameterizedTypeReference<ProductorDTO>(){}
            );
        } catch (ResourceAccessException e) {
            return new ResponseEntity<ProductorDTO>(HttpStatus.SERVICE_UNAVAILABLE);
        }
        if(response.getStatusCode().is2xxSuccessful()) {
            return new ResponseEntity<ProductorDTO>(response.getBody(), HttpStatus.OK);
        } else {
            return new ResponseEntity<ProductorDTO>(response.getBody(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary="Eliminar un productor", description="Se indicara el identificador del productor a eliminar")
    public ResponseEntity<String> deleteProductor(@PathVariable("id") String id) {
        if(api == null) {
            api = "http://localhost:8080/api/v1/productor";
        }
        try {
            template.delete(api + "/" + id);
            return new ResponseEntity<String>("Productor eliminado", HttpStatus.OK);
        }
        catch (ResourceAccessException e) {
            return new ResponseEntity<String>("Error al eliminar el productor", HttpStatus.SERVICE_UNAVAILABLE);
        }
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