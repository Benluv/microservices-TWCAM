package es.uv.bjtwcam.mysql.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es.uv.bjtwcam.mysql.domain.File;
import es.uv.bjtwcam.mysql.domain.File.Estado;


public interface FileRepository extends JpaRepository<File, UUID> {

    List<File> findAllByfileStatus(Estado estado);

    @Query("SELECT f, p "+
           "FROM File f JOIN f.productor p "+
           "ORDER BY f.previsualizaciones DESC, f.descargas DESC")
    List<Object[]> findTop10FilesWithMostViewsAndDownloads();

    @Query("SELECT f " +
           "FROM File f JOIN f.validador v JOIN f.productor p " +
           "WHERE v.id = :validadorId AND p.id = :productorId")
    List<File> findValidatedFilesByValidatorAndProducer(
        @Param("validadorId") String validadorId, 
        @Param("productorId") String productorId);


}