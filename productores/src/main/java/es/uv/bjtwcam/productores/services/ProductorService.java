package es.uv.bjtwcam.productores.services;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import es.uv.bjtwcam.productores.domain.Productor;
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
    
    public Productor createProductor(Productor productor) {
        return new Productor();
    }

    public Productor updateProductor(Productor productor) {
        return new Productor();
    }

    public Productor uploadFile(Productor productor) {
        return new Productor();
    }

    public Productor getProductores() {
        return new Productor();
    }

    public Productor updateFile(Productor productor) {
        return new Productor();
    }

    public Productor deleteFile(Productor productor) {
        return new Productor();
    }
}
