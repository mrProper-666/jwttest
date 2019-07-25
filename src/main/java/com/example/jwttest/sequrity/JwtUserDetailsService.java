package com.example.jwttest.sequrity;

import com.example.jwttest.core.user.User;
import com.example.jwttest.core.user.UserService;
import com.example.jwttest.sequrity.jwt.JwtUser;
import com.example.jwttest.sequrity.jwt.JwtUserFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    private final Logger logger = LoggerFactory.getLogger(JwtUserDetailsService.class);

    private final UserService userService;

    @Autowired
    public JwtUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username);

        if (null == user) {
            throw new UsernameNotFoundException("User with username:" + username + " not found");
        }

        JwtUser jwtUser = JwtUserFactory.create(user);
        logger.info("IN loadUserByUsername - user with username: {} successfully loaded", username);
        return jwtUser;
    }
}
