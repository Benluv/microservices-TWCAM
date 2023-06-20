package es.uv.bjtwcam.consumidores.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import es.uv.bjtwcam.productores.domain.Productor;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ConsumidorService {
    
    public Optional<Productor> getFileByWord() {
        return null;
    }

    public Optional<Productor> getFileByProd() {
        return null;
    }

    public Optional<Productor> getPrevFile() {
        return null;
    }

    public Optional<Productor> getFile() {
        return null;
    }
}
