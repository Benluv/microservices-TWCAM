package es.uv.bjtwcam.productores.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import es.uv.bjtwcam.productores.domain.Productor;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductorService {
    
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
