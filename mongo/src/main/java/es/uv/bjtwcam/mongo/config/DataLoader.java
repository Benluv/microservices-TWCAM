package es.uv.bjtwcam.mongo.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import es.uv.bjtwcam.mongo.domain.File;
import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
/* Para cargar los datos del fichero data.json en la base de datos MongoDB
@Component
public class DataLoader {

    private final MongoRepository<File, String> mongoRepository;

    public DataLoader(MongoRepository<File, String> mongoRepository) {
        this.mongoRepository = mongoRepository;
    }

    @PostConstruct
    public void loadData() {
        try {
            // Leer el archivo data.json de la carpeta resources
            ClassPathResource resource = new ClassPathResource("data.json");
            ObjectMapper objectMapper = new ObjectMapper();
            List<File> files = Arrays.asList(objectMapper.readValue(resource.getInputStream(), File[].class));

            // Guardar los datos en la base de datos MongoDB
            mongoRepository.saveAll(files);
            System.out.println("Datos cargados correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
*/
