package es.uv.bjtwcam.mysql.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.uv.bjtwcam.mysql.mysql.File;

@Repository
public interface FileSQLRepository extends JpaRepository<File, String> {

    List<FileSQL> findAllByfileStatus(String status);
}