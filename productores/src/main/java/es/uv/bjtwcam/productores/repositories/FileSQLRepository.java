package es.uv.bjtwcam.productores.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.uv.bjtwcam.productores.domain.FileSQL;

@Repository
public interface FileSQLRepository extends JpaRepository<FileSQL, String> {

    List<FileSQL> findAllByfileStatus(String status);
    // void update(FileSQL file);
}
