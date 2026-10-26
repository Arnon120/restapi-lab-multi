package com.example.restapi_lab_multi.services;

import com.example.restapi_lab_multi.models.MongoPerson;
import com.example.restapi_lab_multi.models.Phone;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.json.JsonMapper;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PhonesService {
    private final Path filePath = Path.of("data","persons.json");

    private final JsonMapper jsonMapper;

    // Get all
    public List<Phone> getPhones() {
        JsonNode persons = jsonMapper.readTree(filePath.toFile()).get("persons");
        return Arrays.asList(jsonMapper.treeToValue(persons, Phone[].class));
    }

    // Get all, keyed by id
    public Map<Long, Phone> getPhoneById() {
        return getPhones().stream().collect(
                Collectors.toMap(Phone::getId, Function.identity()));
    }
}
