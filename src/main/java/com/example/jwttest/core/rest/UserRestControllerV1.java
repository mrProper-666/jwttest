package com.example.jwttest.core.rest;

import com.example.jwttest.core.user.User;
import com.example.jwttest.core.user.UserService;
import com.example.jwttest.core.user.web.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/users")
public class UserRestControllerV1 {

    private final UserService userService;

    @Autowired
    public UserRestControllerV1(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable(name = "id") Long id) {
        User user = userService.findById(id);

        if (null == user) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        UserResponse result = UserResponse.fromUser(user);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
