package es.uv.bjtwcam.mongo.services;

import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import es.uv.bjtwcam.mongo.domain.File;
import es.uv.bjtwcam.mongo.repositories.FileMongoRepository;

import org.springframework.data.mongodb.core.MongoTemplate;
@Service
public class FileService {
    
	private final String FILE_COLLECTION = "files";

	@Autowired 
	MongoTemplate mongoTemplate;

    @Autowired
    private FileMongoRepository fr;

    public List<File> findAll() {
        return this.fr.findAll();
    }

    public File create(File file) {
        File fileMongo = fr.save(file);
        
		System.out.println("Se copiara: "+fileMongo.getId()+" "+fileMongo.getTitulo());
        
        return fileMongo;
    }

    public void createAll(List<File> posts) {
        this.fr.saveAll(posts);
    }

    public void save(File file) {
        this.fr.save(file);
    }

    public File findFileById(String id) {
        return this.fr.findById(id).orElse(null);
    }

	public void addDataFileToMongoDB(String title, List<Object> data) {

        File file = new File();

		file.setTitulo(title);
		file.setData(data);
        
		File fileMongo = fr.save(file);
		mongoTemplate.insert(fileMongo, FILE_COLLECTION);		
       
		System.out.println("Se copiara: "+fileMongo.getId()+" "+fileMongo.getTitulo());
    }
}