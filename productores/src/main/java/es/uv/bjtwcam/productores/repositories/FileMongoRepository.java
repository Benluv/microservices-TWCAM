package es.uv.bjtwcam.productores.repositories;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import es.uv.bjtwcam.productores.domain.File;

@Repository
public interface FileMongoRepository extends MongoRepository<File, String> {
    
    
}