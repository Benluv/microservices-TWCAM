package es.uv.bjtwcam.productores.controllers;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import es.uv.bjtwcam.productores.domain.File;
import es.uv.bjtwcam.productores.services.FileService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@RestController
@RequestMapping("/api/v1/productor/file")
public class FileController {
    
    @Autowired FileService fs;

    public int cuotaAnual = 5;

	@PostMapping()
    @Operation(summary="Crear nuevo fichero para publicar", description="Solicitud de publicacion de un nuevo fichero")
	public ResponseEntity<File> createFile(@RequestParam MultipartFile file, @RequestParam String title, 
										   @RequestParam String filesize,
										   @RequestParam String description, @RequestParam List<String> keywords,
										   HttpServletRequest request) throws IOException {
		
		String content = new String(file.getBytes(), StandardCharsets.UTF_8);
		ObjectMapper mapper = new ObjectMapper();
		List<Object> data = mapper.readValue(content, mapper.getTypeFactory().constructCollectionType(List.class, Object.class));

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		System.out.println("el usuario es: "+username);
		File f = fs.create(new File(title, filesize, description, keywords, data));

        //fs.addDataFileToMongoDB(title,filesize, description, keywords, data);
		
		return new ResponseEntity<>(f, HttpStatus.OK);

		
	} 
	
	@GetMapping()
    @Operation(summary="Obtener todos los ficheros", description="Obtener todos los ficheros publicados y pendientes")
	public ResponseEntity<List<File>> getAll(HttpServletRequest request) {
		List<File> files = fs.findAll();
		return new ResponseEntity<>(files, HttpStatus.OK);
	}

}