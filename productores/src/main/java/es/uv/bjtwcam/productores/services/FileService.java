package es.uv.bjtwcam.productores.services;

import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import es.uv.bjtwcam.productores.domain.File;
import es.uv.bjtwcam.productores.repositories.FileRepository;

@Service
public class FileService {
    
    @Autowired
    private FileRepository fr;

    public List<File> findAll() {
        return this.fr.findAll();
    }

    
}
