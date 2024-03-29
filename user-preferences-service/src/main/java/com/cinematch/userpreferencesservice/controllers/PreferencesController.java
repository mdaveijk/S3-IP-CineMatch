package com.cinematch.userpreferencesservice.controllers;

import java.util.Collection;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cinematch.userpreferencesservice.models.UserPreferences;
import com.cinematch.userpreferencesservice.services.PreferenceService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/api/userpreferences")
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

    @Operation(summary = "Get a particular set of preferences by userId")
    @GetMapping("/{userid}")
    // Possible responses (this will be shown in the documentation)
    @ApiResponse(responseCode = "200", description = "Successfully found a set of preferences")
    @ApiResponse(responseCode = "404", description = "No preferences found")
    ResponseEntity<UserPreferences> findById(@PathVariable Long userid) {
        UserPreferences result = service.getOneSetOfUserPreferencesById(userid);
        if (result != null) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.notFound().header("Description", "No match with id " + userid + " could be found.")
                    .build();
        }
    }

    @PostMapping
    @ApiResponse(responseCode = "200", description = "Successfully added preferences!")
    @ApiResponse(responseCode = "404", description = "Some data entered is incorrect.")
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

    @Operation(summary = "Update user preferences.")
    @PutMapping("/{userid}")
    @ApiResponse(responseCode = "200", description = "Successfully updated user preferences.")
    @ApiResponse(responseCode = "400", description = "Invalid data entered.")
    @ApiResponse(responseCode = "404", description = "No preferences found.")
    ResponseEntity<UserPreferences> updateUserPreferences(@PathVariable Long userid,
            @Validated @RequestBody UserPreferences userPreferences) {
        UserPreferences existingPreferences = service.getOneSetOfUserPreferencesById(userid);
        if (existingPreferences != null) {
            
            existingPreferences.setMoviePreferences(userPreferences.getMoviePreferences());
            existingPreferences.setGenrePreferences(userPreferences.getGenrePreferences());
            existingPreferences.setLocation(userPreferences.getLocation());

            UserPreferences updatedPreferences = service.updateUserPreferences(existingPreferences);
            return ResponseEntity.ok(updatedPreferences);
        } else {
            return ResponseEntity.notFound()
                    .header("Description", "No preferences for userId " + userid + " could be found.").build();
        }
    }

    @Operation(summary = "Delete user preferences.")
    @DeleteMapping("/{userid}")
    @ApiResponse(responseCode = "204", description = "Successfully deleted user preferences.")
    @ApiResponse(responseCode = "404", description = "No preferences found.")
    ResponseEntity<Void> deleteUserPreferences(@PathVariable Long userid) {
        UserPreferences existingPreferences = service.getOneSetOfUserPreferencesById(userid);
        if (existingPreferences != null) {
            service.deleteUserPreferences(existingPreferences);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound()
                    .header("Description", "No preferences with userId " + userid + " could be found.").build();
        }
    }
}
