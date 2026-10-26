package com.example.restapi_lab_multi.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JsonPlaceholderUser {
    private Long id;
    private String name;
    private String email;
}
