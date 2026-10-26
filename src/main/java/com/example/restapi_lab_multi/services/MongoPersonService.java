package com.example.restapi_lab_multi.services;

import com.example.restapi_lab_multi.models.JsonPlaceholderUser;
import com.example.restapi_lab_multi.models.MongoPerson;
import com.example.restapi_lab_multi.repository.MongoPersonsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class MongoPersonService {
    private final MongoPersonsRepository mongoPersonsRepository;

    public List<MongoPerson> getMongoPersons() {
        return mongoPersonsRepository.findAll();
    }

    // Get all, keyed by id
    public Map<Long, MongoPerson> getMongoPersonsById() {
        return getMongoPersons().stream().collect(
                Collectors.toMap(MongoPerson::getId, Function.identity()));
    }

}
