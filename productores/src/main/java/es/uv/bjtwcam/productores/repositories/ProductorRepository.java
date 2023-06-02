package es.uv.bjtwcam.productores.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import es.uv.bjtwcam.productores.domain.Productor;

//Dudas entre usar ReactiveCrudRepository o JPARepository
@Repository
public interface ProductorRepository extends JpaRepository<Productor, String> {

    Optional<Productor> findByEmail(String email);
}
