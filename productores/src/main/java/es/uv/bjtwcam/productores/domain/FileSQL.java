package es.uv.bjtwcam.productores.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="files")
public class FileSQL {
    
    @Id
    private String id;

    @Column()
    private String fileSize;

    @Column()
    private String fileStatus;

    @Column()
    private String fileTitle;

    @Column()
    private String fileDescription;

}