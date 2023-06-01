package es.uv.bjtwcam.consumidores.repositories;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import es.uv.bjtwcam.productores.domain.Productor;

// Wel'll leave it as ReactiveCrudRepository for now, might change to JPARepository later
public interface ConsumidorRepository extends ReactiveCrudRepository<Productor, Integer> {
    
}
