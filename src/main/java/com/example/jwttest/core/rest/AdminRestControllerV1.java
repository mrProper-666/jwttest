package com.example.jwttest.core.rest;

import com.example.jwttest.core.user.User;
import com.example.jwttest.core.user.UserService;
import com.example.jwttest.core.user.web.AdminUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/admin")
public class AdminRestControllerV1 {

    private final UserService userService;

    @Autowired
    public AdminRestControllerV1(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "users/{id}")
    public ResponseEntity<AdminUserResponse> getUserById(@PathVariable(name = "id") Long id) {
        User user = userService.findById(id);

        if (null == user) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        AdminUserResponse result = AdminUserResponse.fromUser(user);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
