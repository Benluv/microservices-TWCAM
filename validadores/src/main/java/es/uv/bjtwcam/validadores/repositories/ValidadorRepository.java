package es.uv.bjtwcam.validadores.repositories;

import java.util.List;
import java.util.Optional;

import es.uv.bjtwcam.productores.domain.Productor;

public interface ValidadorRepository extends JPARepository<Productor, String>{
    
    Optional<Productor> findByNif(String nif);
    List<Productor> findAll();
    Optional<Productor> save(Productor productor);
    Optional<Void> delete(Productor productor);
    Optional<Productor> update(Productor productor);
}
