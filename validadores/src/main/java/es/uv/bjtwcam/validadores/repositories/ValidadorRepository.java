package es.uv.bjtwcam.validadores.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import es.uv.bjtwcam.productores.domain.Productor;

public interface ValidadorRepository extends JpaRepository<Productor, Integer>{
    
    List<Productor> findAll();
    Optional<Productor> update(Productor productor);
    Productor findById(UUID id);
    Productor findByNif(String nif);
    Productor findByName(String name);
    Productor findByEmail(String email);
    Productor findByType(String type);
    Productor findByEstado(String estado);
    Productor findByCuotaAnual(String cuotaAnual);
}
