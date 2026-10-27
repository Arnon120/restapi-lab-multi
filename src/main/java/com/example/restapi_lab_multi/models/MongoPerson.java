package com.example.restapi_lab_multi.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("persons")
public class MongoPerson {
    @Id
    private String id;
    private Long externalId;
    private String city;
    private String country;
}
