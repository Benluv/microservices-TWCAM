package es.uv.bjtwcam.mysql.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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

    // relacion * a 1 con productor
    @ManyToOne
    @JoinColumn(name = "fk_productor")
    Productor productor;

    // relacion 1 a 1 con validador
    @OneToOne
    @JoinColumn(name = "fk_validador")
    Validador validador;

}