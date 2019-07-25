package com.example.jwttest.core.user.web;

import com.example.jwttest.core.user.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserResponse {
    private Long id;
    private String username;
    private String firstname;
    private String lastname;
    private String email;

    public User toUser() {
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setEmail(email);

        return user;
    }

    public static UserResponse fromUser(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setUsername(user.getUsername());
        userResponse.setFirstname(user.getFirstname());
        userResponse.setLastname(user.getLastname());
        userResponse.setEmail(user.getEmail());

        return userResponse;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
