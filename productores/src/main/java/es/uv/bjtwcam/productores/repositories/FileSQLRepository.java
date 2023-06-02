package es.uv.bjtwcam.productores.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.uv.bjtwcam.productores.domain.FileSQL;

@Repository
public interface FileSQLRepository extends JpaRepository<FileSQL, String> {
    
}
