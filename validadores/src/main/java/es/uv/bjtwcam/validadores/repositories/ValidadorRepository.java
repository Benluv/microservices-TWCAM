package es.uv.bjtwcam.validadores.repositories;

// import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import es.uv.bjtwcam.productores.domain.Productor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ValidadorRepository extends ReactiveCrudRepository<Productor, Integer>{
    
    Mono<Productor> findByNif(String nif);
    Flux<Productor> findAll();
    Mono<Productor> save(Productor productor);
    Mono<Void> delete(Productor productor);
    Mono<Productor> update(Productor productor);
}
