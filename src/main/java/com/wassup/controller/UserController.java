package com.wassup.controller;

import com.wassup.domain.model.Contact;
import com.wassup.domain.model.User;
import com.wassup.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/users")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public void save(@RequestBody final User user) {
        userService.insert(user);
    }

    @GetMapping("/{user}")
    public User getUser(@PathVariable final String user) {
        return userService.getUserByEmail(user);
    }

    @PostMapping("/add/{user}")
    public void addUser(@PathVariable final String user, @RequestBody final Contact newUser) {
        userService.addUser(user, newUser);
    }

}
