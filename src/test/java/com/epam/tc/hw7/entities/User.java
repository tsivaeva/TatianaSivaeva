package com.epam.tc.hw7.entities;

import lombok.Value;

@Value
public class User {

    String name;
    String password;
    String fullName;

    public User(String name, String password, String fullName) {
        this.name = name;
        this.password = password;
        this.fullName = fullName;
    }
}
