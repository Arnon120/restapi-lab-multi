package com.example.restapi_lab_multi.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Address{
        private String city;
        @JsonProperty("Country")
        private String country;
    }

    private Long id;
    private String name;
    private String email;
    private String phone;
    private Address address;

    public static Person FromMembers(JsonPlaceholderUser jsonPlaceholderUser, MongoPerson mongoPerson, Phone phone) {
        assert Objects.equals(jsonPlaceholderUser.getId(), mongoPerson.getExternalId());
        assert Objects.equals(jsonPlaceholderUser.getId(), phone.getId());
        return Person
                .builder()
                .id(jsonPlaceholderUser.getId())
                .name(jsonPlaceholderUser.getName())
                .email(jsonPlaceholderUser.getEmail())
                .phone(phone.getPhone())
                .address(Address
                        .builder()
                        .city(mongoPerson.getCity())
                        .country(mongoPerson.getCountry())
                        .build()
                        )
                .build();
    }
}
