package main.java.com.app.hw26;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {
    Address address;
    String username;
    UUID id;

    public User(String name) {
        username = name;
        id = UUID.randomUUID();
    }
}
