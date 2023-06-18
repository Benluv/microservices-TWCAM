package es.uv.bjtwcam.productores.services;

import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import es.uv.bjtwcam.productores.domain.File;
import es.uv.bjtwcam.productores.domain.FileSQL;
import es.uv.bjtwcam.productores.repositories.FileMongoRepository;
import es.uv.bjtwcam.productores.repositories.FileSQLRepository;

import org.springframework.data.mongodb.core.MongoTemplate;
@Service
public class FileService {
    
	private final String FILE_COLLECTION = "files";

	@Autowired 
	MongoTemplate mongoTemplate;

    @Autowired
    private FileMongoRepository fr;

    @Autowired
    private FileSQLRepository fsr;

    public List<File> findAll() {
        return this.fr.findAll();
    }

    public List<FileSQL> findAllByStatus(String status) {
        return this.fsr.findAllByfileStatus(status);
    }

    public File create(File file) {
        File fileMongo = fr.save(file);

        FileSQL filesql = new FileSQL();
        filesql.setId(fileMongo.getId());
        filesql.setFileStatus("Pending to check");
        filesql.setFileTitle(fileMongo.getTitle());
        filesql.setFileSize(fileMongo.getFileSize());
        filesql.setFileDescription(fileMongo.getDescription());

        
		System.out.println("Se copiara: "+fileMongo.getId()+" "+fileMongo.getTitle()+" "+fileMongo.getFileSize()+" "+fileMongo.getDescription());

        fsr.save(filesql);
        
        return fileMongo;
    }

    public void createAll(List<File> posts) {
        this.fr.saveAll(posts);
    }

    public void save(FileSQL file) {
        this.fsr.save(file);
    }

    public File findFileById(String id) {
        return this.fr.findById(id).orElse(null);
    }

    public FileSQL findSQLFileById(String id) {
        return this.fsr.findById(id).orElse(null);
    }

	public void addDataFileToMongoDB(String title, String filesize,String description, List<String> keywords, List<Object> data) {

        File file = new File();

		file.setTitle(title);
		file.setDescription(description);
		file.setKeywords(keywords);
		file.setData(data);
        
		File fileMongo = fr.save(file);
		File fileMongo2= mongoTemplate.insert(file, FILE_COLLECTION);


		FileSQL filesql = new FileSQL();
		filesql.setId(fileMongo.getId());
		filesql.setFileStatus("Pending to check");
		filesql.setFileTitle(fileMongo.getTitle());
		filesql.setFileSize(fileMongo.getFileSize());
		filesql.setFileDescription(fileMongo.getDescription());
		
       
		System.out.println("Se copiara: "+fileMongo.getId()+" "+fileMongo.getTitle()+" "+fileMongo.getFileSize()+" "+fileMongo.getDescription());
    }
}