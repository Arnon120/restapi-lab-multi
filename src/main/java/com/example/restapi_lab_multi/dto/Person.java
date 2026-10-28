package com.example.restapi_lab_multi.dto;

import com.example.restapi_lab_multi.models.JsonPlaceholderUser;
import com.example.restapi_lab_multi.models.MongoPerson;
import com.example.restapi_lab_multi.models.Phone;
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
        Objects.requireNonNull(jsonPlaceholderUser, "jsonPlaceholderUser");
        Objects.requireNonNull(mongoPerson, "mongoPerson");
        Objects.requireNonNull(phone, "phone");
        Long id = jsonPlaceholderUser.getId();
        if (!Objects.equals(id, mongoPerson.getExternalId()) || !Objects.equals(id, phone.getId())) {
            throw new IllegalArgumentException("Mismatched ids: user=" + id
                    + ", mongoPerson.externalId=" + mongoPerson.getExternalId()
                    + ", phone=" + phone.getId());
        }
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
