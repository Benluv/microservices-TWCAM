package es.uv.bjtwcam.productores.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import es.uv.bjtwcam.productores.domain.File;

public interface FileRepository extends MongoRepository<File, String> {
    
}
