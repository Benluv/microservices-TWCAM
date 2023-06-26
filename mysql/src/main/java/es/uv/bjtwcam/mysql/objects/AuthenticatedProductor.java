package es.uv.bjtwcam.mysql.objects;

public class AuthenticatedProductor {
    
    private String nif;
    
    public AuthenticatedProductor(String nif) {
        this.nif = nif;
    }

    public String getNif() {
        return nif;
    }
}
