package es.uv.bjtwcam.mongo.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Document
public class File {

    @Id
    private String id;
    private String titulo;
    private String tamano;
    private String descripcion;
    private List<String> palabras;
    private List<Object> data;

    public File() {}
	
	public File(File file) {
		this.id = file.getId();
		this.titulo = file.getTitulo();
		this.tamano = file.getTamano();
		this.descripcion = file.getDescripcion();
		this.palabras = file.getPalabras();
		this.data = file.getData();
	}

    public File(String titulo, String tamano, String descripcion, List<String> palabras, List<Object> data) {
        this.titulo = titulo;
        this.tamano = tamano;
        this.descripcion = descripcion;
        this.palabras = palabras;
        this.data = data;
    }
}