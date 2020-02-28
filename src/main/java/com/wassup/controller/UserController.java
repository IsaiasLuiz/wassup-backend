package com.wassup.controller;

import com.wassup.domain.model.User;
import com.wassup.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/users")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public void save(final User user) {
        userService.insert(user);
    }

    @GetMapping
    public User getAll(final String email) {
        return userService.getUserByEmail(email);
    }

    @PostMapping("/add")
    public void addUser(final String email, final User user) {
        userService.addUser(email, user);
    }

}
