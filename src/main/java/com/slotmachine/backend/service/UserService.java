package com.slotmachine.backend.service;

import com.slotmachine.backend.model.User;
import com.slotmachine.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public User login(String email, String password) {
        Optional<User> userOpt = repo.findByEmail(email);
        if (userOpt.isPresent() && userOpt.get().getPassword().equals(password)) {
            return userOpt.get();
        }
        return null;
    }

    public void addPoint(String email) {
        User user = repo.findByEmail(email).orElseThrow();
        user.setPoints(user.getPoints() + 1);
        repo.save(user);
    }

    public int getPoints(String email) {
        return repo.findByEmail(email).map(User::getPoints).orElse(0);
    }
    public boolean emailExists(String email) {
        return repo.findByEmail(email).isPresent();
    }

    public void save(User user) {
        repo.save(user);
    }

}
