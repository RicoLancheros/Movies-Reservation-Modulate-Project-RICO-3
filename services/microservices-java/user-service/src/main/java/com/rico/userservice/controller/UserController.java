package com.rico.userservice.controller;

import com.rico.userservice.model.User;
import com.rico.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//aqui se define el controlador de la aplicacion
@RestController
@RequestMapping("/users")
public class UserController {

    //se inyecta el servicio de usuarios
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
}