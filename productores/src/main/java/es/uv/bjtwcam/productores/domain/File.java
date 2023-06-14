package es.uv.bjtwcam.productores.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class File {

    @Id
    private String id;
    private String title;
    private String description;
    private List<String> keywords;
    private List<String> data;
    private String state;
    private Integer size;
    private Integer previews;
    private Integer downloads;

    public File() {}

    public File(String title, String description, List<String> keywords, List<String> data, String state, Integer size, Integer previews, Integer downloads) {
        this.title = title;
        this.description = description;
        this.keywords = keywords;
        this.state = state;
        this.size = size;
        this.previews = previews;
        this.downloads = downloads;
    }
}
