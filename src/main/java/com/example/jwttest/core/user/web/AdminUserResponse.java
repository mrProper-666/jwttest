package com.example.jwttest.core.user.web;

import com.example.jwttest.core.base.Status;
import com.example.jwttest.core.user.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AdminUserResponse {
    private Long id;
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String status;

    public User toUser() {
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setEmail(email);
        user.setStatus(Status.valueOf(status));

        return user;
    }

    public static AdminUserResponse fromUser(User user) {
        AdminUserResponse adminUserResponse = new AdminUserResponse();
        adminUserResponse.setId(user.getId());
        adminUserResponse.setUsername(user.getUsername());
        adminUserResponse.setFirstname(user.getFirstname());
        adminUserResponse.setLastname(user.getLastname());
        adminUserResponse.setEmail(user.getEmail());
        adminUserResponse.setStatus(user.getStatus().name());

        return adminUserResponse;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
