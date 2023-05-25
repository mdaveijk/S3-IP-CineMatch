package com.cinematch.userdataservice.controllers;

import java.net.URISyntaxException;
import java.util.Collection;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cinematch.userdataservice.models.User;
import com.cinematch.userdataservice.repositories.UserRepository;

@RestController
@RequestMapping("/api/users")
public class UserController {
    
    private UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    Collection<User> users()    {
        return (Collection<User>) repository.findAll();
    }

    @PostMapping
    ResponseEntity<User> createContact(@Validated @RequestBody User user) throws URISyntaxException {
        User result = repository.save(user);
        return ResponseEntity.ok().body(result);
    }
}
