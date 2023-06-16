package com.cinematch.userpreferencesservice.services;

import java.util.Collection;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cinematch.userpreferencesservice.models.UserPreferences;
import com.cinematch.userpreferencesservice.repositories.PreferencesRepository;

@Service
public class PreferenceService {

    private PreferencesRepository repository;
    private Collection<UserPreferences> userPreferences;

    public PreferenceService(PreferencesRepository repository) {
        this.repository = repository;
        this.userPreferences = this.repository.findAll();
    }

    public Collection<UserPreferences> getAllPreferences() {
        return this.userPreferences;
    }

    public UserPreferences createUserPreferences(UserPreferences userPreferences) {
        // Validate the location
        if (!isLocationValid(userPreferences.getLocation())) {
            throw new IllegalArgumentException("Invalid location");
        }

        // Save the user preferences
        UserPreferences result = repository.save(userPreferences);
        return result;
    }

    public boolean isLocationValid(String location) {
        if (location == null) {
            return false;
        }

        // Check if the location contains numbers
        if (containsNumbers(location)) {
            return false;
        }

        // Check if the location contains special characters
        if (containsSpecialCharacters(location)) {
            return false;
        }

        return true;
    }

    private boolean containsNumbers(String location) {
        // Regular expression pattern to match any digit
        String regex = ".*\\d.*";
        return location.matches(regex);
    }

    //TODO this method does not work properly
    private boolean containsSpecialCharacters(String location) {
        // Regular expression pattern to match special characters
        String regex = "[^A-Za-z0-9]";
        return location.matches(regex);
    }

}
