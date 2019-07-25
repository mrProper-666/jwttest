package com.example.jwttest.core.user.impl;

import com.example.jwttest.core.base.Status;
import com.example.jwttest.core.user.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepo userRepo,
                           RoleRepo roleRepo,
                           BCryptPasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User register(User user) {
        Role roleUser = roleRepo.findByName("ROLE_USER");
        List<Role> userRoles = new ArrayList<>();
        userRoles.add(roleUser);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(userRoles);
        user.setStatus(Status.ACTIVE);

        User registeredUser = userRepo.save(user);

        logger.info("IN register - user: {} successfully registered", registeredUser);

        return registeredUser;
    }

    @Override
    public List<User> getAll() {
        List<User> result = userRepo.findAll();
        logger.info("IN getAll - {} users found", result.size());
        return result;
    }

    @Override
    public User findByUsername(String username) {
        User result = userRepo.findByUsername(username);
        logger.info("IN findByUsername - user: {} found by username: {}", result, username);
        return result;
    }

    @Override
    public User findById(Long id) {
        User result = userRepo.findById(id).orElse(null);

        if (null == result) {
            logger.warn("IN findById - no user found by id: {}", id);
            return null;
        }

        logger.info("IN findById - user: {} found by id: {}", result, id);
        return result;
    }

    @Override
    public void delete(Long id) {
        userRepo.deleteById(id);
        logger.info("IN delete - user with id: {} successfully deleted", id);
    }
}
