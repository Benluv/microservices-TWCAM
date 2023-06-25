package es.uv.bjtwcam.productores.domain;

import java.io.Serializable;
import java.util.Arrays;
import java.util.UUID;

import lombok.Data;

@Data
public class Productor implements Serializable {

    private UUID id;

    private String nif;

    private String nombre;

    private Tipo tipo;

    private Estado estado;

    private Integer cuota;

    private String email;

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
        fisica {
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
