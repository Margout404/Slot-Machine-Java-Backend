package com.slotmachine.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;

    private String password;

    private int points = 0;

    public User() {}

    public User(String email, String password) {
        this.email = email;
        this.password = password;
        this.points = 0;
    }

    public Long getId() { return id; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public int getPoints() { return points; }
    public void setPoints(int points) { this.points = points; }
}
