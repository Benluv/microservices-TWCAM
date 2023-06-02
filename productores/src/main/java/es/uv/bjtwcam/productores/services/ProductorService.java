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
