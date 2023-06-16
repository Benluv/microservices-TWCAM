package es.uv.bjtwcam.validadores.services;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import es.uv.bjtwcam.productores.domain.Productor;
import es.uv.bjtwcam.validadores.repositories.ValidadorRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ValidadorService {
    
    @Autowired
    private ValidadorRepository vr;

    public List<Productor> findAll() {
        return vr.findAll();
    }

    public Productor findById(UUID id) {
        return vr.findById(id);
    }

    public Productor findByNif(String nif) {
        return vr.findByNif(nif);
    }

    public Productor findByName(String name) {
        return vr.findByName(name);
    }

    public Productor findByEmail(String email) {
        return vr.findByEmail(email);
    }

    public Productor findByType(String type) {
        return vr.findByType(type);
    }

    public Productor findByEstado(String estado) {
        return vr.findByEstado(estado);
    }

    public Productor findByCuotaAnual(String cuotaAnual) {
        return vr.findByCuotaAnual(cuotaAnual);
    }

    public Productor aprobarProductor(Productor productor) {
        productor.setApproved();
        return vr.save(productor);
    }

    public Optional<Productor> updateProductor(Productor productor) {
        return vr.update(productor);
    }

    public void deleteProductor(Productor productor) {
        vr.delete(productor);
    }
}