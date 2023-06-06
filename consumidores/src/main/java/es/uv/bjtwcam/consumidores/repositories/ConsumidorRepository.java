package es.uv.bjtwcam.consumidores.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import es.uv.bjtwcam.productores.domain.Productor;

// Wel'll leave it as ReactiveCrudRepository for now, might change to JPARepository later
public interface ConsumidorRepository extends JpaRepository<Productor, Integer> {
    
}
