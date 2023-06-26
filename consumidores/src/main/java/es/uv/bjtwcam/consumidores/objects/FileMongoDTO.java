package es.uv.bjtwcam.consumidores.objects;

import java.io.Serializable;

public class FileMongoDTO implements Serializable {
    
    private String id;
    private String titulo;
    private String data;

    public FileMongoDTO() {
    }

    public FileMongoDTO(String id, String titulo, String data) {
        this.id = id;
        this.titulo = titulo;
        this.data = data;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getId() {
        return this.id;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public String getData() {
        return this.data;
    }
}
