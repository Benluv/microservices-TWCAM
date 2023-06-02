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

@Entity
@Table(name = "productor")
public class Productor implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private Integer id;

    @Column(name = "NIF", nullable = false, length = 9, unique = true)
    private String nif;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false)
    private Type type;

    @Column(nullable = false)
    private Estado estado;

    @Column(name="cuotaAnual", nullable = false)
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

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setType(Type type) {
        this.type = type;
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

    public enum Type {
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