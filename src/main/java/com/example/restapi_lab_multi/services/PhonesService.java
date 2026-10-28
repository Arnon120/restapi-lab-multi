package com.example.restapi_lab_multi.services;

import com.example.restapi_lab_multi.models.Phone;
import org.springframework.beans.factory.annotation.Value;
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
class PhonesService {
    private final Path filePath;

    private final JsonMapper jsonMapper;

    PhonesService(@Value("${phones.file-path}") Path filePath, JsonMapper jsonMapper) {
        this.filePath = filePath;
        this.jsonMapper = jsonMapper;
    }

    // Get all
    private List<Phone> getPhones() {
        JsonNode persons = jsonMapper.readTree(filePath.toFile()).get("persons");
        return Arrays.asList(jsonMapper.treeToValue(persons, Phone[].class));
    }

    // Get all, keyed by id
    Map<Long, Phone> getPhoneById() {
        return getPhones().stream().collect(
                Collectors.toMap(Phone::getId, Function.identity()));
    }
}
