package es.uv.bjtwcam.productores.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
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

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public List<String> getData() {
        return data;
    }

    public String getState() {
        return state;
    }

    public Integer getSize() {
        return size;
    }

    public Integer getPreviews() {
        return previews;
    }

    public Integer getDownloads() {
        return downloads;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public void setPreviews(Integer previews) {
        this.previews = previews;
    }

    public void setDownloads(Integer downloads) {
        this.downloads = downloads;
    }
}
