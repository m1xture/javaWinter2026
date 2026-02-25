package com.app.hw18;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class UserRepository {
    private final List<User> users;

    public UserRepository() throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        users = Arrays.asList(mapper.readValue(Paths.get("src/main/java/com/app/hw18/users.json").toFile(), User[].class));

    }

    public Optional<List<User>> findAllUsers() {
        return Optional.ofNullable(users);
    }

    public Optional<User> findUserById(int id) {
        return users.stream().filter(user -> id == user.getId()).findFirst();
    }

    public Optional<User> findUserByEmail(String email) {
        return users.stream().filter(user -> user.getEmail().equals(email)).findFirst();
    }


}
