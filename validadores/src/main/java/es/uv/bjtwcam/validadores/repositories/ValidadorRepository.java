package es.uv.bjtwcam.validadores.repositories;

// import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import es.uv.bjtwcam.validadores.domain.Validador;

public interface ValidadorRepository extends ReactiveCrudRepository<Validador, Integer>{
    
}
