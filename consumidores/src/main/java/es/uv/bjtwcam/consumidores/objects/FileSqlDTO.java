package es.uv.bjtwcam.consumidores.objects;

import java.io.Serializable;

public class FileSqlDTO implements Serializable {
    
    private String id;
    private String fecha;
    private String titulo;
    private String descripcion;
    private String tamano;
    private String palabras;
    private String previsualizaciones;
    private String descargas;
    private String estado;
    private String productor;
    private String validador;

    public FileSqlDTO() {
    }

    public FileSqlDTO(String id, String fecha, String titulo, String descripcion, String tamano, String palabras, String previsualizaciones, String descargas, String estado, String productor, String validador) {
        this.id = id;
        this.fecha = fecha;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.tamano = tamano;
        this.palabras = palabras;
        this.previsualizaciones = previsualizaciones;
        this.descargas = descargas;
        this.estado = estado;
        this.productor = productor;
        this.validador = validador;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    public void setPalabras(String palabras) {
        this.palabras = palabras;
    }

    public void setPrevisualizaciones(String previsualizaciones) {
        this.previsualizaciones = previsualizaciones;
    }

    public void setDescargas(String descargas) {
        this.descargas = descargas;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setProductor(String productor) {
        this.productor = productor;
    }

    public void setValidador(String validador) {
        this.validador = validador;
    }

    public String getId() {
        return id;
    }

    public String getFecha() {
        return fecha;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getTamano() {
        return tamano;
    }

    public String getPalabras() {
        return palabras;
    }

    public String getPrevisualizaciones() {
        return previsualizaciones;
    }

    public String getDescargas() {
        return descargas;
    }

    public String getEstado() {
        return estado;
    }

    public String getProductor() {
        return productor;
    }

    public String getValidador() {
        return validador;
    }
}
