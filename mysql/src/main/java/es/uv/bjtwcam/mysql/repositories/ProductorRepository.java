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
    
    //Was attempting to make this work to have a generic way to search by any field but it didn't work
    //Like the idea though so I'll leave it here
    // @Query("SELECT p FROM Productor p WHERE LOWER(p.column) = LOWER(:value)")
    // List<Productor> findAllByField(@Param("column") String column, @Param("value") String value);
}
