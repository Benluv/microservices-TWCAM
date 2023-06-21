package es.uv.bjtwcam.validadores.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import es.uv.bjtwcam.validadores.objects.ProductorDTO;

//This will be discontinued
public interface ValidadorRepository extends JpaRepository<ProductorDTO, Integer>{
    
    List<ProductorDTO> findAll();
    Optional<ProductorDTO> update(ProductorDTO productor);
    ProductorDTO findById(UUID id);
    ProductorDTO findByNif(String nif);
    ProductorDTO findByName(String name);
    ProductorDTO findByEmail(String email);
    ProductorDTO findByType(String type);
    ProductorDTO findByEstado(String estado);
    ProductorDTO findByCuotaAnual(String cuotaAnual);
}
