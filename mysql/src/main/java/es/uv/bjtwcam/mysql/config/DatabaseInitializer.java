package es.uv.bjtwcam.mysql.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import es.uv.bjtwcam.mysql.domain.Productor;
import es.uv.bjtwcam.mysql.repositories.ProductorRepository;
import es.uv.bjtwcam.mysql.domain.Productor.Estado;
import es.uv.bjtwcam.mysql.domain.Productor.Tipo;

@Component
public class DatabaseInitializer implements CommandLineRunner {
    
    @Autowired
    private ProductorRepository pr;

    @Override
    public void run(String... args) throws Exception {
        //initialize Tipo enum
        Tipo tipo = Tipo.valueOf("fisica");
        Estado estado = Estado.valueOf("activo");
        
        // Verificar si los datos ya están inicializados
        if (!pr.findAll().isEmpty()) {
            System.out.println("Los datos ya están inicializados. No se realizará ninguna acción adicional.");
            return;
        }
        // Crea algunos usuarios de ejemplo
        Productor productor1 = new Productor();
        productor1.setEmail("productor@test.com");
        // productor1.setPassword("$2a$10$hXEkVHymxIlYccM5nQFbVOmNNYSZ0dUoJ4FgmK6jLLHkjiQLQIm8m"); //clave: Test1234 encriptada con algoritmo HMAC-SHA 
        productor1.setPassword("Test1234");
        productor1.setNombre("productor");
        productor1.setCuota(3);
        productor1.setNif("y8287176z");
        productor1.setTipo(tipo);
        productor1.setEstado(estado);

        // Guarda los usuarios en la base de datos
        pr.save(productor1);
    }
}