package es.uv.bjtwcam.validadores.objects;

import java.io.Serializable;

public class ValidadorDTO implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private String id;
    private String nombre;
    private String email;
    private String password;

    public ValidadorDTO() {
    }

    public ValidadorDTO(String id, String nombre, String email, String password) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
    
    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return String.format(
            "Validador[id=%s, nombre=%s, email=%s, password=%s]",
            this.getId(),
            this.getNombre(),
            this.getEmail(),
            this.getPassword()
        );
    }
}