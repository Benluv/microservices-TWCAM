package es.uv.bjtwcam.mysql.domain;

import java.sql.Date;
import java.util.Arrays;
import java.util.UUID;
import java.util.List;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
@Table(name="files", schema="portalAyuntDB")
public class File {
    
    @Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(updatable = false, nullable = false, unique = true)
    private UUID id;

    @Column(updatable = false, nullable = false, name="fecha_creacion")
    private Date fecha;

    @Column(nullable = false)
    private String titulo;

    @Column()
    private String descripcion;

    @Column(nullable = false, name = "tamano")
    private Integer tamano;

    @ElementCollection
    @CollectionTable(name = "file_palabras_clave", joinColumns = @JoinColumn(name = "file_id"), schema="portalAyuntDB")
    @Column(name = "palabras_clave")
    private List<String> palabras;

    @Column(nullable = false)
    private Integer previsualizaciones;

    @Column(nullable = false)
    private Integer descargas;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Estado estado;

    
    // relacion * a 1 con productor
    @ManyToOne
    @JoinColumn(name = "fk_productor")
    Productor productor;

    // relacion 1 a 1 con validador
    @OneToOne
    @JoinColumn(name = "fk_validador")
    Validador validador;

    public void setApproved() {
        //get names from status
        String[] estados = Estado.getNames(Estado.class);
        //check if estado is pendiente
        if (this.estado == Estado.valueOf(estados[0]))
            //set estado to activo
            this.estado = Estado.valueOf(estados[1]);
    }

    public enum Estado {
        pendiente {
            @Override
            public String toString() {
                return "pendiente";
            }
        },
        activo {
            @Override
            public String toString() {
                return "activo";
            }
        };
        public static String[] getNames(Class<? extends Enum<?>> e) {
            return Arrays.stream(e.getEnumConstants()).map(Enum::name).toArray(String[]::new);
        }
    }

}