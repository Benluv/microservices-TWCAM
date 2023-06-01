package es.uv.bjtwcam.productores.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="productores")
public class Productor implements Serializable{
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private Integer id;

    @Column(nullable=false, length=9, unique=true)
    private String nif;

    @Column(nullable=false, length=50)
    private String nombre;

    @Column(nullable=false)
    private tipo tipo;

    @Column(nullable=false)
    private estado estado;

    @Column(nullable=false, name="cuota_anual")
    private float cuota;

    @Column(nullable=false)
    private String email;

    @Column(nullable=false)
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

    public tipo getTipo() {
        return tipo;
    }

    public estado getEstado() {
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

    public void setTipo(tipo tipo) {
        this.tipo = tipo;
    }

    public void setEstado(estado estado) {
        this.estado = estado;
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
}

enum tipo {
    persona {
        public String toString() {
            return "persona física";
        }
    },
    juridica {
        public String toString() {
            return "persona jurídica";
        }
    }
}

enum estado {
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
    }
}