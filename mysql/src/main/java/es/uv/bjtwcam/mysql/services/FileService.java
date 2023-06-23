package es.uv.bjtwcam.mysql.services;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import es.uv.bjtwcam.mysql.domain.File;
import es.uv.bjtwcam.mysql.repositories.FileRepository;

@Service
public class FileService {

    @Autowired
    private FileRepository fr;

    public List<File> findAll() {
        return this.fr.findAll();
    }


    public File create(File file) {
        fr.save(file);
        return file;
    }

    public void save(File file) {
        this.fr.save(file);
    }

    public File findSQLFileById(String id) {
        //from String to uuid
        UUID id_ = UUID.fromString(id);
        return this.fr.findById(id_).orElse(null);
    }
}