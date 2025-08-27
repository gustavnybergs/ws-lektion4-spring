package com.gustav.lektion4.controller;

import com.gustav.lektion4.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class UserController {

    @GetMapping("/newUser")
    public User getNewUser() {
        return new User(0, "Benny", "123", true);
    }

    @GetMapping("/users/{username}")
    public User getByUsername(@PathVariable String username) {
        return new User(0, username, "123", true);
    }
}


