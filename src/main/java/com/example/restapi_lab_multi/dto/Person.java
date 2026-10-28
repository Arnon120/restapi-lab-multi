package com.example.restapi_lab_multi.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Person {
    Long id;
    String name;
    String email;
    String phone;
    Address address;
}
