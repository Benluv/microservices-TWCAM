package es.uv.bjtwcam.productores.services;

import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import es.uv.bjtwcam.productores.domain.FileSQL;
import es.uv.bjtwcam.productores.repositories.FileSQLRepository;

@Service
public class FileService {

    @Autowired
    private FileSQLRepository fsr;


    public List<FileSQL> findAllByStatus(String status) {
        return this.fsr.findAllByfileStatus(status);
    }

    public void save(FileSQL file) {
        this.fsr.save(file);
    }

    public FileSQL findSQLFileById(String id) {
        return this.fsr.findById(id).orElse(null);
    }
}