package es.uv.bjtwcam.mysql.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import es.uv.bjtwcam.mysql.domain.Productor;
import es.uv.bjtwcam.mysql.domain.Productor.Estado;
import es.uv.bjtwcam.mysql.domain.Productor.Tipo;

public interface ProductorRepository extends JpaRepository<Productor, UUID> {

    Optional<Productor> findByNif(String nif);
    Optional<Productor> findByNifAndPassword(String nif, String password);
    Optional<List<Productor>> findAllByNombre(String name);
    Optional<Productor> findByEmail(String email);
    Optional<List<Productor>> findAllByTipo(Tipo tipo);
    Optional<List<Productor>> findAllByEstado(Estado estado);
    Optional<List<Productor>> findAllByCuota(Integer cuota);
    Optional<List<Productor>> findAllByNombreContaining(String name);
    List<Productor> findAll();

    @Query("SELECT p.estado, COUNT(p) FROM Productor p GROUP BY p.estado")
    List<Object[]> countProductorsByEstado();

    @Query("SELECT p FROM Productor p WHERE (SELECT COUNT(f) FROM File f WHERE f.productor.id = p.id) > 5")
    List<Productor> findProductorsWithMoreThan5Files();

    
    //Was attempting to make this work to have a generic way to search by any field but it didn't work
    //Like the idea though so I'll leave it here
    // @Query("SELECT p FROM Productor p WHERE LOWER(p.column) = LOWER(:value)")
    // List<Productor> findAllByField(@Param("column") String column, @Param("value") String value);
}


/*
 *  Example of how to do rest template
            try {
                response = template.getForEntity(url+"/"+ id, ProductorDTO.class);
            } 
            catch (ResourceAccessException e) {
                return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
            }
            if(response.getStatusCode() == HttpStatus.OK) {
                log.info("Obteniendo productor con id: {}", id);
                p.add(response.getBody());
                return new ResponseEntity<List<ProductorDTO>>(p, HttpStatus.OK);
            } else {
                log.error("No existe el productor con id: {}", id);
                return ResponseEntity.notFound().build();
            }
 */