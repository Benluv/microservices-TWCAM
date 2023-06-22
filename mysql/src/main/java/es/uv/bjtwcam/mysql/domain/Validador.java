package es.uv.bjtwcam.mysql.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="validadores")
public class Validador implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private Integer id;

    @Column(nullable=false, length=50)
    private String nombre;

    @Column(nullable=false)
    private String email;

    @Column(nullable=false)
    private String password;
}