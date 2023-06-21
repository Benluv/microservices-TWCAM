package es.uv.bjtwcam.validadores.services;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import es.uv.bjtwcam.validadores.objects.ProductorDTO;
import es.uv.bjtwcam.validadores.repositories.ValidadorRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ValidadorService {
    
    @Autowired
    private ValidadorRepository vr;

    public List<ProductorDTO> findAll() {
        return vr.findAll();
    }

    public ProductorDTO findById(UUID id) {
        return vr.findById(id);
    }

    public ProductorDTO findByNif(String nif) {
        return vr.findByNif(nif);
    }

    public ProductorDTO findByName(String name) {
        return vr.findByName(name);
    }

    public ProductorDTO findByEmail(String email) {
        return vr.findByEmail(email);
    }

    public ProductorDTO findByType(String type) {
        return vr.findByType(type);
    }

    public ProductorDTO findByEstado(String estado) {
        return vr.findByEstado(estado);
    }

    public ProductorDTO findByCuotaAnual(String cuotaAnual) {
        return vr.findByCuotaAnual(cuotaAnual);
    }

    public ProductorDTO aprobarProductor(ProductorDTO productor) {
        // productor.setApproved();
        return vr.save(productor);
    }

    public Optional<ProductorDTO> updateProductor(ProductorDTO productor) {
        return vr.update(productor);
    }

    public void deleteProductor(ProductorDTO productor) {
        vr.delete(productor);
    }
}