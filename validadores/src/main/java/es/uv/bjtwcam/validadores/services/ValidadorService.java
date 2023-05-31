package es.uv.bjtwcam.validadores.services;
import es.uv.bjtwcam.productores.domain.Productor;
import reactor.core.publisher.Flux;
public class ValidadorService {
    
    public Flux<Productor> getProductores() {
        return Flux.just(new Productor());
    }
}
