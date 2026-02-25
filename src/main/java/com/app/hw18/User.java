package com.app.hw18;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private int id;
    private String name;
    private String email;

    @Override
    public String toString() {
        return String.format("User{id=%d, name=%s, email=%s}", id, name, email);
    }
}
