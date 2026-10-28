package com.example.restapi_lab_multi.models;

import lombok.Builder;
import lombok.Value;

import java.util.Objects;

@Value
@Builder
public class Person {
    Long id;
    String name;
    String email;
    String phone;
    Address address;

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
