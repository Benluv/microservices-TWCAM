package es.uv.bjtwcam.consumidores.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import es.uv.bjtwcam.productores.domain.Productor;

public interface ConsumidorRepository extends JpaRepository<Productor, Integer> {
    
}
