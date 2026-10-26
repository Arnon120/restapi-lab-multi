package com.example.restapi_lab_multi.services;

import com.example.restapi_lab_multi.models.JsonPlaceholderUser;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class JsonPlaceholderUserService {
    private final RestClient restClient;

    public JsonPlaceholderUserService() {
        this.restClient = RestClient.builder().baseUrl("https://jsonplaceholder.typicode.com").build();
    }

    // Get All
    public List<JsonPlaceholderUser> getUsers() {
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
    public Map<Long, JsonPlaceholderUser> getUsersByID() {
        return getUsers().stream().collect(
                Collectors.toMap(JsonPlaceholderUser::getId, Function.identity()));
    }
}
