package es.uv.bjtwcam.productores.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import es.uv.bjtwcam.productores.repositories.ProductorRepository;

@Component
public class DatabaseInitializer implements CommandLineRunner {
    
    @Autowired
    private ProductorRepository pr;

    @Override
    public void run(String... args) throws Exception {
        
        // Verificar si los datos ya están inicializados
        if (!pr.findAll().isEmpty()) {
            System.out.println("Los datos ya están inicializados. No se realizará ninguna acción adicional.");
            return;
        }
        // Crea algunos usuarios de ejemplo
        Productor productor1 = new Productor();
        productor1.setEmail("productor@test.com");
        productor1.setPassword("$2a$10$hXEkVHymxIlYccM5nQFbVOmNNYSZ0dUoJ4FgmK6jLLHkjiQLQIm8m"); //clave: Test1234 encriptada con algoritmo HMAC-SHA 
        productor1.setName("productor");
        productor1.setCuotaAnual("");
        productor1.setNIF("");
        productor1.setType("");
        productor1.setEstado("Activo");



        // Guarda los usuarios en la base de datos
        pr.save(productor1);
    }
}
