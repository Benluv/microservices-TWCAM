package es.uv.bjtwcam.mongo.repositories;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import es.uv.bjtwcam.mongo.domain.File;

@Repository
public interface FileMongoRepository extends MongoRepository<File, String> {
    
    
}