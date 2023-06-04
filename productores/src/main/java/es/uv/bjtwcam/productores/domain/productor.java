package es.uv.bjtwcam.productores.domain;

import java.io.Serializable;
import java.util.Arrays;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "productor")
public class Productor implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private Integer id;

    @Column(name = "NIF", nullable = false, length = 9, unique = true)
    private String NIF;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String estado;

    @Column(name="cuotaAnual", nullable = false)
    private String cuotaAnual;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    /* ENUM FOR TYPE. STRING USED INSTEAD
    public enum Types {
        persona {
            public String toString() {
                return"persona física";
            }
        },
        juridica {
            public String toString() {
                return"persona jurídica";
            }
        };
        public static String[] getNames(Class<? extends Enum<?>> e) {
            return Arrays.stream(e.getEnumConstants()).map(Enum::name).toArray(String[]::new);
        }
    }
    */

    /*
     * ENUM FOR ESTADO. STRING USED INSTEAD
    public enum Estado {
        pendiente { 
            public String toString() {
                return "pendiente de Aprobación";
            }
        },
        activo {
            public String toString() {
                return "activo";
            }
        },
        inactivo {
            public String toString() {
                return "inactivo";
            }
        };
        public static String[] getNames(Class<? extends Enum<?>> e) {
            return Arrays.stream(e.getEnumConstants()).map(Enum::name).toArray(String[]::new);
        }
    }
    */
    public void setApproved() {
        // //get names from estado
        // String[] estados = Estado.getNames(Estado.class);
        // //check if estado is pendiente
        // if (this.estado == Estado.valueOf(estados[0]))
        //     //set estado to activo
        //     this.estado = Estado.valueOf(estados[1]);
        if (this.getEstado().equals("pendiente") || this.getEstado().equals("pendiente de Aprobación"))
            this.setEstado("activo");
    }
}