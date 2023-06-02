package es.uv.bjtwcam.productores.services;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import es.uv.bjtwcam.productores.domain.Productor;
import es.uv.bjtwcam.productores.objects.ProductorDTO;
import es.uv.bjtwcam.productores.repositories.ProductorRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductorService {

    @Autowired
    ProductorRepository pr;

    public void insert(ProductorDTO newUser) { 

        Productor productor = new Productor();

        productor.setEmail(newUser.getEmail());
        String pass = new BCryptPasswordEncoder().encode(newUser.getPassword());
        productor.setPassword(pass);
        productor.setName(newUser.getName());
        productor.setCuotaAnual(newUser.getCuotaAnual());
        productor.setNIF(newUser.getNIF());
        productor.setType(newUser.getType());
        productor.setEstado("");

        // Validar y establecer el campo "estado" como vacío si es nulo o vacío en la solicitud
        if (!newUser.getEstado().isEmpty()) {
            productor.setEstado("Pending");
        } else {
            productor.setEstado("Pending");
        }
            pr.save(productor);
    }

    public Productor getProductorById(String productorId) {
        return pr.findById(productorId).orElse(null);
    }
    
    public void update(String productorId, ProductorDTO updatedProductor) {

        // Obtener el usuario existente por ID
        Productor productor = getProductorById(productorId);

        // Actualizar los campos modificables del usuario existente
        productor.setEmail(updatedProductor.getEmail());
        String pass = new BCryptPasswordEncoder().encode(updatedProductor.getPassword());
        productor.setPassword(pass);
        productor.setName(updatedProductor.getName());
        productor.setCuotaAnual(updatedProductor.getCuotaAnual());
        productor.setNIF(updatedProductor.getNIF());
        productor.setType(updatedProductor.getType());

        if (! productor.getEstado().isEmpty()|| !productor.getEstado().equals("Pending")|| 
        !productor.getEstado().equals("Activo") ||
        !productor.getEstado().equals("Inactivo")   
        ) {
            productor.setEstado("Pending");
        } else {
            productor.setEstado(productor.getEstado());
        }
        pr.save(productor);
    }
    
    // public Mono<Productor> createProductor(Productor productor) {
    //     return Mono.just(productor);
    // }

    // public Mono<Productor> updateProductor(Productor productor) {
    //     return Mono.just(productor);
    // }

    // public Mono<Productor> uploadFile(Productor productor) {
    //     return Mono.just(productor);
    // }

    // public Flux<Productor> getProductores() {
    //     return Flux.empty();
    // }

    // public Mono<Productor> updateFile(Productor productor) {
    //     return Mono.just(productor);
    // }

    // public Mono<Productor> deleteFile(Productor productor) {
    //     return Mono.just(productor);
    // }
}
