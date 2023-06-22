package es.uv.bjtwcam.mysql.services;

import java.util.List;
import java.util.Optional;

// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import es.uv.bjtwcam.mysql.domain.Productor;
import es.uv.bjtwcam.mysql.domain.Productor.Estado;
import es.uv.bjtwcam.mysql.domain.Productor.Tipo;
import es.uv.bjtwcam.mysql.repositories.ProductorRepository;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

@Service
@Transactional
public class ProductorService {

    @Autowired
    ProductorRepository pr;

    public Optional<Productor> login(String nif, String password) {
        return pr.findByNifAndPassword(nif, password);
    }

    // public Productor insert(Productor productor) {
    //         productor.setEstado(Estado.pendiente);

    //     if (productor.getCuota() == null) {
    //         productor.setCuota(0);
    //     }
    //     // if productor.getTipo is null or "fisica" or "juridica" then set productor.getTipo to "fisica
    //     if (productor.getTipo() == null || productor.getTipo().toString().equals("fisica"))
    //         productor.setTipo(Tipo.fisica);
    //     else if (productor.getTipo().toString().equals("juridica"))
    //         productor.setTipo(Tipo.juridica);
    //     else
    //         return null;

    //     try{
    //         String pass = new BCryptPasswordEncoder().encode(productor.getPassword());
    //         productor.setPassword(pass);
    //     } catch(Exception e){
    //         return null;
    //     }
    //     return pr.save(productor);
    // }

    public Productor getProductorById(String productorNif) {
        return pr.findByNif(productorNif).orElse(null);
    }

    public List<Productor> findAll() {
        return pr.findAll();
    }

    public List<Productor> findAllByField(String field, String value) {
        return pr.findAllByField(field, value);
    }

    // public void update(String productorId, ProductorDTO updatedProductor) {

    //     // Obtener el usuario existente por ID
    //     Productor productor = getProductorById(productorId);
    //     Tipo tipo = Tipo.valueOf(updatedProductor.getTipo());
    //     Integer cuota = Integer.valueOf(updatedProductor.getCuota());

    //     // Actualizar los campos modificables del usuario existente
    //     productor.setEmail(updatedProductor.getEmail());
    //     String pass = new BCryptPasswordEncoder().encode(updatedProductor.getPassword());
    //     productor.setPassword(pass);
    //     productor.setNombre(updatedProductor.getNombre());
    //     productor.setCuota(cuota);
    //     productor.setNif(updatedProductor.getNif());
    //     productor.setTipo(tipo);
    //     // Validar y establecer el campo "estado" si no es nulo ni vacío en la solicitud
    //     if (updatedProductor.getEstado() != null && !updatedProductor.getEstado().isEmpty()) {
    //         Estado estado = Estado.valueOf(updatedProductor.getEstado());
    //         productor.setEstado(estado);
    //     }
    //     pr.save(productor);
    // }
}
