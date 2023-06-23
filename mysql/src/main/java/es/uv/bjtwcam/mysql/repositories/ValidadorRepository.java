package es.uv.bjtwcam.mysql.repositories;


import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import es.uv.bjtwcam.mysql.domain.Validador;

public interface ValidadorRepository extends JpaRepository<Validador, UUID>{
    
}
