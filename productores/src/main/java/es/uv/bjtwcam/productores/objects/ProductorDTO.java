package es.uv.bjtwcam.productores.objects;

import java.io.Serializable;

import lombok.Data;

@Data
public class ProductorDTO implements Serializable {
    
    // private static final long serialVersionUID = 1L;
    private String NIF;
    private String Name;
    private String Type;
    private String estado;
    private String CuotaAnual;
    private String email;
    private String password;

    // This should be handled with lomdok.data
    // @Override
    // public String toString() {
    //     return String.format(
    //         "Productor{id=%s, nif=%s, nombre=%s, tipo=%s, estado=%s, cuota=%s, email=%s, password=%s}", 
    //         this.getId(), 
    //         this.getNif(), 
    //         this.getNombre(),
    //         this.getTipo(),
    //         this.getEstado(),
    //         this.getCuota(),
    //         this.getEmail(), 
    //         this.getPassword()
    //     );
    // }
}
