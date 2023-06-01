package es.uv.bjtwcam.validadores.repositories;

import java.util.UUID;

// import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import es.uv.bjtwcam.productores.domain.Productor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ValidadorRepository extends ReactiveCrudRepository<Productor, Integer>{
    
    Mono<Productor> findById(UUID id);
    Flux<Productor> findAll();
}
