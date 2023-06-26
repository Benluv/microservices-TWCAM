package es.uv.bjtwcam.mysql.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import es.uv.bjtwcam.mysql.domain.Productor;
import es.uv.bjtwcam.mysql.domain.Productor.Estado;
import es.uv.bjtwcam.mysql.domain.Productor.Tipo;
import es.uv.bjtwcam.mysql.interfaces.ProductorServiceInterface;
import es.uv.bjtwcam.mysql.repositories.ProductorRepository;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

@Service
@Transactional
public class ProductorService implements ProductorServiceInterface {

    @Autowired
    ProductorRepository pr;

    public Optional<Productor> login(String nif, String password) {
        return pr.findByNifAndPassword(nif, password);
    }

    public Productor insert(Productor productor) {

        productor.setEstado(Estado.pendiente);
        if (productor.getCuota() == null) {
            productor.setCuota(0);
        }
        // if productor.getTipo is null or "fisica" or "juridica" then set productor.getTipo to "fisica
        if (productor.getTipo() == null || productor.getTipo().toString().equals("fisica"))
            productor.setTipo(Tipo.fisica);
        else if (productor.getTipo().toString().equals("juridica"))
            productor.setTipo(Tipo.juridica);
        else
            return null;

        try{
            // String pass = new BCryptPasswordEncoder().encode(productor.getPassword());
            productor.setPassword(productor.getPassword());
        } catch(Exception e){
            return null;
        }
        return pr.save(productor);
    }

    public List<Productor> findAll() {
        return pr.findAll();
    }

    public Productor findById(String id) {
        UUID id_;
        try {
            id_ = UUID.fromString(id);
        } catch (Exception e) {
            return null;
        }
        return pr.findById(id_).isPresent() ? pr.findById(id_).get() : null;
    }

    public Productor findByNif(String productorNif) {
        return pr.findByNif(productorNif).isPresent() ? pr.findByNif(productorNif).get() : null;
    }

    public List<Productor> findAllByNombre(String name) {
        return pr.findAllByNombre(name).isPresent() ? pr.findAllByNombre(name).get() : null;
    }

    public Productor findByEmail(String email) {
        return pr.findByEmail(email).isPresent() ? pr.findByEmail(email).get() : null;
    }

    public List<Productor> findAllByTipo(String tipo) {
        Tipo tipoEnum;
        
        if (tipo == null || tipo.isEmpty() || (!tipo.contains("fisica") && !tipo.contains("juridica")) )
            return null;
        else if (tipo.contains("fisica"))
            tipoEnum = Tipo.fisica;
        else if (tipo.contains("juridica"))
            tipoEnum = Tipo.juridica;
        else
            return null;

        return pr.findAllByTipo(tipoEnum).isPresent() ? pr.findAllByTipo(tipoEnum).get() : null;
    }

    public List<Productor> findAllByEstado(String estado) {
        Estado estadoEnum;

        if (estado == null || estado.isEmpty() || (!estado.contains("pendiente") && !estado.contains("activo") && !estado.contains("inactivo")) )
            return null;
        else if (estado.contains("pendiente"))
            estadoEnum = Estado.pendiente;
        else if (estado.contains("aprobado"))
            estadoEnum = Estado.activo;
        else if (estado.contains("rechazado"))
            estadoEnum = Estado.inactivo;
        else
            return null;

        return pr.findAllByEstado(estadoEnum).isPresent() ? pr.findAllByEstado(estadoEnum).get() : null;
    }

    public List<Productor> findAllByCuota(String cuota) {
        Integer cuotaInteger = Integer.valueOf(cuota);
        return pr.findAllByCuota(cuotaInteger).isPresent() ? pr.findAllByCuota(Integer.valueOf(cuotaInteger)).get() : null;
    }

    public Productor aprobarProductor(Productor productor) {
        productor.setApproved();
        return pr.save(productor);
    }


    public Productor update(String productorId, Productor updatedProductor) {
        // Obtener el usuario existente por ID
        Productor productor = pr.findById(UUID.fromString(productorId)).get();
        
        // Tipo tipo = Tipo.valueOf(updatedProductor.getTipo());
        // Integer cuota = Integer.valueOf(updatedProductor.getCuota());

        // Actualizar los campos modificables del usuario existente
        productor.setEmail(updatedProductor.getEmail());
        // String pass = new BCryptPasswordEncoder().encode(updatedProductor.getPassword());
        productor.setPassword(updatedProductor.getPassword());
        productor.setNombre(updatedProductor.getNombre());
        productor.setCuota(updatedProductor.getCuota());
        productor.setNif(updatedProductor.getNif());
        productor.setTipo(updatedProductor.getTipo());
        productor.setEstado(updatedProductor.getEstado());
        pr.save(productor);
        return productor;
    }
    
    public void delete(String productorId) {
        pr.deleteById(UUID.fromString(productorId));
    }
}
