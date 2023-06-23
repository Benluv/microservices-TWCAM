package es.uv.bjtwcam.mysql.domain;

import java.util.Arrays;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
    @Column(updatable = false, nullable = false)
    private UUID id;

    @Column(nullable = false)
    private String fileSize;

    @Column(nullable = false)
    private Estado fileStatus;

    @Column(nullable = false)
    private String fileTitle;

    @Column()
    private String fileDescription;

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
        if (this.fileStatus == Estado.valueOf(estados[0]))
            //set estado to activo
            this.fileStatus = Estado.valueOf(estados[1]);
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