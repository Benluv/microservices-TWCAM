package es.uv.bjtwcam.productores.services;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import es.uv.bjtwcam.productores.domain.Productor;
import es.uv.bjtwcam.productores.domain.Productor.Estado;
import es.uv.bjtwcam.productores.domain.Productor.Tipo;
import es.uv.bjtwcam.productores.objects.ProductorDTO;
import es.uv.bjtwcam.productores.repositories.ProductorRepository;
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
    
    public void insert(ProductorDTO newUser) { 

        Productor productor = new Productor();

        Tipo tipo = Tipo.valueOf(newUser.getTipo());
        Estado estado = Estado.valueOf(newUser.getEstado());
        Float cuota = Float.valueOf(newUser.getCuota());

        productor.setEmail(newUser.getEmail());
        String pass = new BCryptPasswordEncoder().encode(newUser.getPassword());
        productor.setPassword(pass);
        productor.setNombre(newUser.getNombre());
        productor.setCuota(cuota.intValue());
        productor.setNif(newUser.getNif());
        productor.setTipo(tipo);
        productor.setEstado(estado);

        // Validar y establecer el campo "estado" como vacío si es nulo o vacío en la solicitud
        if (!newUser.getEstado().isEmpty()) {
            productor.setEstado(Estado.pendiente);
        } else {
            productor.setEstado(Estado.pendiente);
        }
            pr.save(productor);
    }

    public Productor getProductorById(String productorNif) {
        return pr.findByNif(productorNif).orElse(null);
    }

        public void update(String productorId, ProductorDTO updatedProductor) {

        // Obtener el usuario existente por ID
        Productor productor = getProductorById(productorId);
        Tipo tipo = Tipo.valueOf(updatedProductor.getTipo());
        Integer cuota = Integer.valueOf(updatedProductor.getCuota());

        // Actualizar los campos modificables del usuario existente
        productor.setEmail(updatedProductor.getEmail());
        String pass = new BCryptPasswordEncoder().encode(updatedProductor.getPassword());
        productor.setPassword(pass);
        productor.setNombre(updatedProductor.getNombre());
        productor.setCuota(cuota);
        productor.setNif(updatedProductor.getNif());
        productor.setTipo(tipo);
        // Validar y establecer el campo "estado" si no es nulo ni vacío en la solicitud
        if (updatedProductor.getEstado() != null && !updatedProductor.getEstado().isEmpty()) {
            Estado estado = Estado.valueOf(updatedProductor.getEstado());
            productor.setEstado(estado);
        }
        pr.save(productor);
    }
}
