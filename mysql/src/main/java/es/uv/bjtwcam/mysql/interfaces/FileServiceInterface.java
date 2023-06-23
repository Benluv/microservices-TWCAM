package es.uv.bjtwcam.mysql.interfaces;

import java.util.List;

import es.uv.bjtwcam.mysql.domain.File;

public interface FileServiceInterface {
    public List<File> findAll();
    public File create(File file);
    public void save(File file);
    public File findFileById(String id);

}
