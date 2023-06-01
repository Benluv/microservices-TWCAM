package es.uv.bjtwcam.productores.services;

import es.uv.bjtwcam.productores.domain.Productor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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
