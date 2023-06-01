package es.uv.bjtwcam.validadores.services;
import es.uv.bjtwcam.productores.domain.Productor;
import reactor.core.publisher.Flux;
public class ValidadorService {
    
    public Flux<Productor> getProductores() {
        return Flux.just(new Productor());
    }

    public Flux<Productor> aprobarProductor() {
        return Flux.just(new Productor());
    }

    public Flux<Productor> updateProductor() {
        return Flux.just(new Productor());
    }

    public Flux<Productor> deleteProductor() {
        return Flux.just(new Productor());
    }

    public Flux<Productor> getFicheros() {
        return Flux.just(new Productor());
    }

    public Flux<Productor> publicarFichero() {
        return Flux.just(new Productor());
    }
}
