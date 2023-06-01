package es.uv.bjtwcam.validadores.services;
import org.springframework.stereotype.Service;

import es.uv.bjtwcam.productores.domain.Productor;
import jakarta.transaction.Transactional;
import reactor.core.publisher.Flux;

@Service
@Transactional
public class ValidadorService {
    
    public Flux<Productor> getProductores() {
        return Flux.just(new Productor());
    }

    public Flux<Productor> aprobarProductor() {
        return Flux.just(new Productor());
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
}
