package com.cinematch.userpreferencesservice.controllers;

import java.net.URISyntaxException;
import java.util.Collection;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cinematch.userpreferencesservice.models.UserPreferences;
import com.cinematch.userpreferencesservice.repositories.PreferencesRepository;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/userpreferences")
@CrossOrigin(origins = "http://localhost:5173/")
public class PreferencesController {
    private PreferencesRepository repository;

    public PreferencesController(PreferencesRepository repository) {
        this.repository = repository;
    }

    // Brief summary of the endpoint
    @Operation(summary = "Get a list of all matches.")
    @GetMapping
    Collection<UserPreferences> allPreferences() {
        return (Collection<UserPreferences>) repository.findAll();
    }

    @PostMapping
    ResponseEntity<UserPreferences> createUserPreferences(@Validated @RequestBody UserPreferences userPreferences) throws URISyntaxException {
        UserPreferences result = repository.save(userPreferences);
        return ResponseEntity.ok().body(result);
    }
}
