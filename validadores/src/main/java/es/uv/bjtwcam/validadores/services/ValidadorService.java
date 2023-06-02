package es.uv.bjtwcam.validadores.services;
import java.util.List;
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

    public List<Productor> findAll() {
        return vr.findAll();
    }

    // public Mono<Productor> aprobarProductor(Productor productor) {
    //     productor.setApproved();
    //     return vr.save(productor);
    // }

    // public Mono<Productor> updateProductor(Productor productor) {
    //     return vr.update(productor);
    // }

    // public void deleteProductor(Productor productor) {
    //     vr.delete(productor);
    // }

    // public Flux<Productor> getFicheros() {
    //     return Flux.just(new Productor());
    // }

    // public Flux<Productor> publicarFichero() {
    //     return Flux.just(new Productor());
    // }

    // public Mono<Productor> findByNif(String nif) {
    //     return vr.findByNif(nif);
    // }
}
