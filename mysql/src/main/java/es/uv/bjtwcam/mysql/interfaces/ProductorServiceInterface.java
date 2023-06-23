package es.uv.bjtwcam.mysql.interfaces;

import java.util.List;
import java.util.Optional;

import es.uv.bjtwcam.mysql.domain.Productor;
import es.uv.bjtwcam.mysql.objects.ProductorDTO;

public interface ProductorServiceInterface {
    
    Optional<Productor> login(String nif, String password);
    Productor insert(Productor productor);
    List<Productor> findAll();
    Productor findById(String id);
    Productor findByNif(String productorNif);
    List<Productor> findAllByNombre(String name);
    Productor findByEmail(String email);
    List<Productor> findAllByTipo(String tipo);
    List<Productor> findAllByEstado(String estado);
    List<Productor> findAllByCuota(String cuota);
    Productor aprobarProductor(Productor productor);
    Productor update(String id, Productor productor);
    void delete(String id);
}
