package es.uv.bjtwcam.mysql.objects;

import java.io.Serializable;

import es.uv.bjtwcam.mysql.domain.Productor;

public class ProductorDTO implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private String id;
    private String nif;
    private String nombre;
    private String tipo;
    private String estado;
    private String cuota;
    private String email;
    private String password;

    public ProductorDTO() {
    }

    public ProductorDTO(Productor p) {

        this.id = p.getId().toString();
        this.nif = p.getNif().toString();
        this.nombre = p.getNombre();
        this.tipo = p.getTipo().toString();
        this.estado = p.getEstado().toString();
        this.cuota = p.getCuota().toString();
        this.email = p.getEmail();
        this.password = p.getPassword();
    }

    public ProductorDTO(String id, String nif, String nombre, String tipo, String estado, String cuota, String email, String password) {
        this.id = id;
        this.nif = nif;
        this.nombre = nombre;
        this.tipo = tipo;
        this.estado = estado;
        this.cuota = cuota;
        this.email = email;
        this.password = password;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setCuota(String cuota) {
        this.cuota = cuota;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getNif() {
        return nif;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public String getEstado() {
        return estado;
    }

    public String getCuota() {
        return String.valueOf(cuota);
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return String.format(
            "Productor{id=%s, nif=%s, nombre=%s, tipo=%s, estado=%s, cuota=%s, email=%s, password=%s}", 
            this.getId(), 
            this.getNif(), 
            this.getNombre(),
            this.getTipo(),
            this.getEstado(),
            this.getCuota(),
            this.getEmail(), 
            this.getPassword()
        );
    }
}
