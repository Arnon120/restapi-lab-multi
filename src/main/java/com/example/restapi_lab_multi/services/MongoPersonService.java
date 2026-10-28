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
class MongoPersonService {
    private final MongoPersonsRepository mongoPersonsRepository;

    private List<MongoPerson> getMongoPersons() {
        return mongoPersonsRepository.findAll();
    }

    // Get all, keyed by externalId (the user id; _id is Mongo's own ObjectId)
    Map<Long, MongoPerson> getMongoPersonsById() {
        return getMongoPersons().stream().collect(
                Collectors.toMap(MongoPerson::getExternalId, Function.identity()));
    }

}
