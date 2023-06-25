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
    private List<Object> data;

    public File() {}
	
	public File(File file) {
		this.id = file.getId();
        this.titulo = file.getTitulo();
		this.data = file.getData();
	}

    public File(String titulo, List<Object> data) {
        this.titulo = titulo;
        this.data = data;
    }
}