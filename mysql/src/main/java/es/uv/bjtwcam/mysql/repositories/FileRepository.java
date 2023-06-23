package es.uv.bjtwcam.mysql.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import es.uv.bjtwcam.mysql.domain.File;
import es.uv.bjtwcam.mysql.domain.File.Estado;


public interface FileRepository extends JpaRepository<File, UUID> {

    List<File> findAllByfileStatus(Estado estado);
}