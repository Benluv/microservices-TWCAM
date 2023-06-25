package es.uv.bjtwcam.productores.domain;

import lombok.Data;

@Data
public class FileSQL {
    
    private String id;
    private String fileSize;
    private String fileStatus;
    private String fileTitle;
    private String fileDescription;

}