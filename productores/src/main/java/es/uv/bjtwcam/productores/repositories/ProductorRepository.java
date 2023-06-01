package es.uv.bjtwcam.productores.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import es.uv.bjtwcam.productores.domain.Productor;

//Dudas entre usar ReactiveCrudRepository o JPARepository
public interface ProductorRepository extends JpaRepository<Productor, Integer> {
    
}
