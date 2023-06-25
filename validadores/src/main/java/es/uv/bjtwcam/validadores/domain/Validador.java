package es.uv.bjtwcam.validadores.domain;

import java.io.Serializable;

import lombok.Data;

@Data
public class Validador implements Serializable {

    private Integer id;
    private String nombre;
    private String email;
    private String password;
}