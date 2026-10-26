package com.example.restapi_lab_multi.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MongoPerson {
    @Id
    private Long id;
    private String city;
    private String country;
}
