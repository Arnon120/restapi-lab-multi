package com.example.restapi_lab_multi.services;

import com.example.restapi_lab_multi.models.JsonPlaceholderUser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
class JsonPlaceholderUserService {
    private final RestClient restClient;

    JsonPlaceholderUserService(@Value("${jsonplaceholder.base-url}") String baseUrl) {
        this.restClient = RestClient.builder().baseUrl(baseUrl).build();
    }

    // Get All
    private List<JsonPlaceholderUser> getUsers() {
        JsonPlaceholderUser[] users = Optional
                .ofNullable(restClient
                    .get()
                    .uri("/users")
                    .retrieve()
                    .body(JsonPlaceholderUser[].class)
                           )
                .orElse(new JsonPlaceholderUser[]{});

        return Arrays.asList(users);
    }

    // Get all, keyed by id
    Map<Long, JsonPlaceholderUser> getUsersById() {
        return getUsers().stream().collect(
                Collectors.toMap(JsonPlaceholderUser::getId, Function.identity()));
    }
}
