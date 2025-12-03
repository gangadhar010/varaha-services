package com.varaha.web.controller;

import com.varaha.common.model.User;
import com.varaha.common.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService = new UserService();

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable String id) {
        return userService.getUserById(id);
    }
}
