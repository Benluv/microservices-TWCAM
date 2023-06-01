package es.uv.bjtwcam.productores.domain;

import java.io.Serializable;
import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "productores")
public class Productor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
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

    public Integer getId() {
        return id;
    }

    public String getNif() {
        return nif;
    }

    public String getNombre() {
        return nombre;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public Estado getEstado() {
        return estado;
    }

    public float getCuota() {
        return cuota;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void setApproved() {
        //get names from estado
        String[] estados = Estado.getNames(Estado.class);
        //check if estado is pendiente
        if (this.estado == Estado.valueOf(estados[0]))
            //set estado to activo
            this.estado = Estado.valueOf(estados[1]);
    }

    public void setCuota(float cuota) {
        this.cuota = cuota;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
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