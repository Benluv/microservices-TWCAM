package es.uv.bjtwcam.productores.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import es.uv.bjtwcam.productores.domain.Productor;

public interface ProductorRepository extends JpaRepository<Productor, Integer> {

}
