package es.uv.bjtwcam.mysql.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es.uv.bjtwcam.mysql.domain.Productor;

public interface ProductorRepository extends JpaRepository<Productor, Integer> {

    Optional<Productor> findByNif(String nif);
    Optional<Productor> findByNifAndPassword(String nif, String password);
    
    //doess not work
    @Query("SELECT p FROM Productor p WHERE LOWER(p.:field) = LOWER(:value)")
    List<Productor> findAllByField(@Param("field") String field, @Param("value") String value);
}
