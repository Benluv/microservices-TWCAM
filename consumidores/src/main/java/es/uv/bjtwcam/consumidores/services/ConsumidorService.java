package es.uv.bjtwcam.consumidores.services;

import org.springframework.stereotype.Service;

import es.uv.bjtwcam.productores.domain.Productor;
import jakarta.transaction.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Transactional
public class ConsumidorService {
    
    public Flux<Productor> getFileByWord() {
        return Flux.just(new Productor());
    }

    public Flux<Productor> getFileByProd() {
        return Flux.just(new Productor());
    }

    public Mono<Productor> getPrevFile() {
        return Mono.just(new Productor());
    }

    public Mono<Productor> getFile() {
        return Mono.just(new Productor());
    }
}
