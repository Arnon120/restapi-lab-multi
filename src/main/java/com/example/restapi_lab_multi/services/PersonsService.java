package com.example.restapi_lab_multi.services;

import com.example.restapi_lab_multi.dto.Person;
import com.example.restapi_lab_multi.models.JsonPlaceholderUser;
import com.example.restapi_lab_multi.models.MongoPerson;
import com.example.restapi_lab_multi.models.Phone;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class PersonsService {
    private final JsonPlaceholderUserService jsonPlaceholderUserService;
    private final MongoPersonService mongoPersonService;
    private final PhonesService phonesService;

    public List<Person> getPersons() {
        Map<Long, JsonPlaceholderUser> jsonPlaceholderUsers = jsonPlaceholderUserService.getUsersByID();
        Map<Long, MongoPerson> mongoPeople = mongoPersonService.getMongoPersonsById();
        Map<Long, Phone> phones = phonesService.getPhoneById();

        Set<Long> commonIds = new HashSet<>(jsonPlaceholderUsers.keySet());
        commonIds.retainAll(mongoPeople.keySet());
        commonIds.retainAll(phones.keySet());
        return commonIds.stream()
                .map(id -> Person.FromMembers(jsonPlaceholderUsers.get(id), mongoPeople.get(id), phones.get(id)))
                .toList();
    }
}
