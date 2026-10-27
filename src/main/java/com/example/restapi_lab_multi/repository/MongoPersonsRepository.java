package com.example.restapi_lab_multi.repository;

import com.example.restapi_lab_multi.models.MongoPerson;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoPersonsRepository extends MongoRepository<MongoPerson, String> {
}
