package com.example.restapi_lab_multi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Address {
    String city;
    @JsonProperty("Country")
    String country;
}
