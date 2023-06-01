package es.uv.bjtwcam.productores.repositories;

// import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import es.uv.bjtwcam.productores.domain.Productor;

//Dudas entre usar ReactiveCrudRepository o JPARepository
public interface ProductorRepository extends ReactiveCrudRepository<Productor, Integer> {

}
