package es.uv.bjtwcam.mongo.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Document
public class File {

    @Id
    private String id;
    private String title;
    private String filesize;
    private String description;
    private List<String> keywords;
    private List<Object> data;

    public File() {}

    public File(String title, String filesize, String description, List<String> keywords, List<Object> data) {
        this.title = title;
        this.filesize = filesize;
        this.description = description;
        this.keywords = keywords;
        this.data = data;
    }
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFileSize() {
		return filesize;
	}
	public void setFileSize(String filesize) {
		this.filesize = filesize;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<String> getKeywords() {
		return keywords;
	}
	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}
	public List<Object> getData() {
		return data;
	}
	public void setData(List<Object> data) {
		this.data = data;
	}
}