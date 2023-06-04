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
public class Productor {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(name = "NIF")
    private String NIF;

    @Column(nullable = false)
    private String name;

    @Column()
    private String type;

    @Column()
    private String cuotaAnual;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;
    
    @Column()
    private String estado;

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
        if (this.getEstado().equals("pendiente") || this.getEstado().equals("pendiente de Aprobación"))
            this.setEstado("activo");
    }
}