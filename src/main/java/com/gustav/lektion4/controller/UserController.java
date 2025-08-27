package com.gustav.lektion4.controller;

import com.gustav.lektion4.model.User;
import com.gustav.lektion4.model.CustomUser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    private final List<CustomUser> userList = new ArrayList<>(List.of(
            new CustomUser(1, "User1"),
            new CustomUser(2, "User2"),
            new CustomUser(3, "User3")
    ));

    @GetMapping("/newUser")
    public User getNewUser() {
        return new User(0, "Benny", "123", true);
    }

    @GetMapping("/users/{username}")
    public User getByUsername(@PathVariable String username) {
        return new User(0, username, "123", true);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteById(@PathVariable long id) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).id() == id) {
                var removed = userList.remove(i);
                return ResponseEntity.ok(removed); // alt: .noContent().build()
            }
        }
        return ResponseEntity.notFound().build();
    }
}
