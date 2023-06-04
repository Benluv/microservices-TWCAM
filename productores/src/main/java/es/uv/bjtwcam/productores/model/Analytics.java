package es.uv.bjtwcam.productores.model;

import org.springframework.data.mongodb.core.mapping.Document;

import org.springframework.data.annotation.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Analytics {
    @Id
    private String id; // Auto assigned by MongoDB

    private String userId;
    private Long userLoginCount;
    
}
