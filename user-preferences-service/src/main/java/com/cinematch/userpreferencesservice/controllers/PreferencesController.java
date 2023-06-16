package com.cinematch.userpreferencesservice.controllers;

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
import com.cinematch.userpreferencesservice.services.PreferenceService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/userpreferences")
@CrossOrigin(origins = "http://localhost:5173/")
public class PreferencesController {

    private PreferenceService service;

    public PreferencesController(PreferenceService service) {
        this.service = service;
    }

    // Brief summary of the endpoint
    @Operation(summary = "Get a list of all user preferences.")
    @GetMapping
    Collection<UserPreferences> allPreferences() {
        return service.getAllPreferences();
    }

    @PostMapping
    ResponseEntity<UserPreferences> createUserPreferences(@Validated @RequestBody UserPreferences userPreferences) {
           ResponseEntity<UserPreferences> response;
    
    if (service.isLocationValid(userPreferences.getLocation())) {
        UserPreferences result = service.createUserPreferences(userPreferences);
        response = ResponseEntity.ok().body(result);
        } else {
            response = ResponseEntity.badRequest().build();
        }
        
        return response;
    }
}
