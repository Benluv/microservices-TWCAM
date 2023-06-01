package es.uv.bjtwcam.validadores.services;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import es.uv.bjtwcam.productores.domain.Productor;
import es.uv.bjtwcam.validadores.repositories.ValidadorRepository;
import jakarta.transaction.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Transactional
public class ValidadorService {
    
    @Autowired
    private ValidadorRepository vr;

    public Flux<Productor> findAll() {
        return vr.findAll();
    }

    public Mono<Productor> aprobarProductor(Productor productor) {
        productor.setApproved();
        return vr.save(productor);
    }

    public Flux<Productor> updateProductor() {
        return Flux.just(new Productor());
    }

    public Flux<Productor> deleteProductor() {
        return Flux.just(new Productor());
    }

    public Flux<Productor> getFicheros() {
        return Flux.just(new Productor());
    }

    public Flux<Productor> publicarFichero() {
        return Flux.just(new Productor());
    }

    public Mono<Productor> findById(UUID id) {
        return vr.findById(id);
    }
}
