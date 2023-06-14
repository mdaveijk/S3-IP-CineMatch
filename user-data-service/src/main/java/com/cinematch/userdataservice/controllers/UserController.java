package com.cinematch.userdataservice.controllers;

import java.util.Collection;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cinematch.userdataservice.models.User;
import com.cinematch.userdataservice.repositories.UserRepository;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:5173/")
public class UserController {
    
    private UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    //Brief summary of the endpoint
    @Operation(summary = "Get a list of all users.")
    @GetMapping
    public Collection<User> users()    {
        return (Collection<User>) repository.findAll();
    }

    @PostMapping
    public ResponseEntity<User> createUser(@Validated @RequestBody User user) {
        User result = repository.save(user);
        return ResponseEntity.ok().body(result);
    }
}
