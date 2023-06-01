package es.uv.bjtwcam.productores.services;

import org.springframework.stereotype.Service;

import es.uv.bjtwcam.productores.domain.Productor;
import jakarta.transaction.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Transactional
public class ProductorService {
    
    public Mono<Productor> createProductor(Productor productor) {
        return Mono.just(productor);
    }

    public Mono<Productor> updateProductor(Productor productor) {
        return Mono.just(productor);
    }

    public Mono<Productor> uploadFile(Productor productor) {
        return Mono.just(productor);
    }

    public Flux<Productor> getProductores() {
        return Flux.empty();
    }

    public Mono<Productor> updateFile(Productor productor) {
        return Mono.just(productor);
    }

    public Mono<Productor> deleteFile(Productor productor) {
        return Mono.just(productor);
    }
}
