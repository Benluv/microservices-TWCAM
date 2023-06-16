package es.uv.bjtwcam.productores.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import es.uv.bjtwcam.productores.domain.Productor;

public interface ProductorRepository extends JpaRepository<Productor, Integer> {

    Optional<Productor> findByNif(String nif);
    Optional<Productor> findByNifAndPassword(String nif, String password);
}
