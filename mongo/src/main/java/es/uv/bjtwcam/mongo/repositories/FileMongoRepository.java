package es.uv.bjtwcam.mongo.repositories;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import es.uv.bjtwcam.mongo.domain.File;

@Repository
public interface FileMongoRepository extends MongoRepository<File, String> {
    
    @Query(value = "{$match: {_id: ?0}}, {$project: {data: {$slice: ['$data', 10]}}}")
    List<Object> findFirst10LinesById(String id);
}