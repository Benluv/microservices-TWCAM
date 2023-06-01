package es.uv.bjtwcam.validadores.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import es.uv.bjtwcam.validadores.domain.Validador;

public interface ValidadorRepository extends JpaRepository<Validador, Integer>{
    
}
