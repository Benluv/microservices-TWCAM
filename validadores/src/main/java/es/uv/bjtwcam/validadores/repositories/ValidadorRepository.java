package es.uv.bjtwcam.validadores.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import es.uv.bjtwcam.productores.domain.Productor;

public interface ValidadorRepository extends JPARepository<Productor, String>{
    
    List<Productor> findAll();
    Optional<Productor> save(Productor productor);
    Optional<Void> delete(Productor productor);
    Optional<Productor> update(Productor productor);
    Productor findById(UUID id);
    Productor findByNif(String nif);
    Productor findByName(String name);
    Productor findByEmail(String email);
    Productor findByType(String type);
    Productor findByEstado(String estado);
    Productor findByCuotaAnual(String cuotaAnual);

}
