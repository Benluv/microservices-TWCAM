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

@Entity
@Data
@Table(name = "productores")
public class Productor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 9, unique = true)
    private String nif;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(nullable = false)
    private Tipo tipo;

    @Column(nullable = false)
    private Estado estado;

    @Column(nullable = false, name = "cuota_anual")
    private float cuota;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    public void setApproved() {
        //get names from estado
        String[] estados = Estado.getNames(Estado.class);
        //check if estado is pendiente
        if (this.estado == Estado.valueOf(estados[0]))
            //set estado to activo
            this.estado = Estado.valueOf(estados[1]);
    }
    
    public enum Tipo {
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
}