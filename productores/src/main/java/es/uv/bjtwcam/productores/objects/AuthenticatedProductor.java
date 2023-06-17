package es.uv.bjtwcam.productores.objects;

public class AuthenticatedProductor {
    
    private String nif;
    
    public AuthenticatedProductor(String nif) {
        this.nif = nif;
    }

    public String getNif() {
        return nif;
    }
}
