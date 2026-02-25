package com.app.hw18;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        try {
            UserRepository userRepository = new UserRepository();
            Optional<User> userById = userRepository.findUserById(2);
            Optional<User> userById2 = userRepository.findUserById(78);

            userById.ifPresent(user -> System.out.println(user.toString()));
            userById2.ifPresent(user -> System.out.println(user.toString()));

            // B

            List<Optional<User>> usersByEmail = List.of(userRepository.findUserByEmail("lalala@null.com"), userRepository.findUserByEmail("MO94MYq@gmai.com"));
            usersByEmail.forEach(user -> {
                if (user.isPresent()) {
                    System.out.println(user.get().toString());
                } else {
                    System.out.println("Value is not present");
                }
            });

            // C

            Optional<List<User>> users = userRepository.findAllUsers();
            users.ifPresent(userList -> System.out.println(userList.size()));

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
