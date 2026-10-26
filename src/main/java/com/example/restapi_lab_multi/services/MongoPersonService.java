package com.example.restapi_lab_multi.services;

import com.example.restapi_lab_multi.models.MongoPerson;
import com.example.restapi_lab_multi.repository.MongoPersonsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class MongoPersonService {
    private final MongoPersonsRepository mongoPersonsRepository;

    public List<MongoPerson> getMongoPersons() {
        return mongoPersonsRepository.findAll();
    }

}
