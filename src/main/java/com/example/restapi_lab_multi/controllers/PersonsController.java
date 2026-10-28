package com.example.restapi_lab_multi.controllers;

import com.example.restapi_lab_multi.dto.Person;
import com.example.restapi_lab_multi.services.PersonsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class PersonsController {

    private final PersonsService personsService;

    @GetMapping
    public List<Person> getAll() {
        return personsService.getPersons();
    }
}
