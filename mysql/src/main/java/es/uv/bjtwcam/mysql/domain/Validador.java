package es.uv.bjtwcam.mysql.domain;

import java.io.Serializable;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="validadores", schema="portalAyuntDB")
public class Validador implements Serializable {

    @Id 
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(updatable = false, nullable = false)
    private UUID id;

    @Column(nullable=false, length=50)
    private String nombre;

    @Column(nullable=false)
    private String email;

    @Column(nullable=false)
    private String password;
}