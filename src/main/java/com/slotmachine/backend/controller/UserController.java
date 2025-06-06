package com.slotmachine.backend.controller;

import com.slotmachine.backend.service.UserService;
import com.slotmachine.backend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> body) {
        String email = body.get("email");
        String password = body.get("password");

        User user = service.login(email, password);
        if (user != null) {
            return ResponseEntity.ok(Map.of("email", user.getEmail()));
        }
        return ResponseEntity.status(401).body(Map.of("message", "Invalid credentials"));
    }

    @PostMapping("/spin")
    public ResponseEntity<?> spin(@RequestBody Map<String, String> body) {
        String email = body.get("email");

        int[] result = new Random().ints(3, 0, 3).toArray();
        boolean win = result[0] == result[1] && result[1] == result[2];

        if (win) {
            service.addPoint(email);
        }

        int points = service.getPoints(email);

        return ResponseEntity.ok(Map.of(
                "result", result,
                "win", win,
                "points", points
        ));
    }
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String, String> body) {
        String email = body.get("email");
        String password = body.get("password");

        if (service.emailExists(email)) {
            return ResponseEntity.status(409).body(Map.of("message", "Email already exists"));
        }

        User newUser = new User(email, password);
        service.save(newUser);
        return ResponseEntity.ok(Map.of("message", "User created"));
    }

}
