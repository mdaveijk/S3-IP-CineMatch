package com.cinematch.userpreferencesservice.services;

import java.util.Collection;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cinematch.userpreferencesservice.models.UserPreferences;
import com.cinematch.userpreferencesservice.repositories.PreferencesRepository;

@Service
public class PreferenceService {

    private PreferencesRepository repository;

    public PreferenceService(PreferencesRepository repository) {
        this.repository = repository;
    }

    public Collection<UserPreferences> getAllPreferences() {
        return this.repository.findAll();
    }

    public UserPreferences getOneSetOfUserPreferencesById(Long id) {
        Optional<UserPreferences> optionalPreferences = repository.findById(id);
        if (optionalPreferences.isPresent()) {
            return optionalPreferences.get();
        } else {
            return null;
        }
    }


    public UserPreferences createUserPreferences(UserPreferences userPreferences) {
        // Validate the location
        if (!isLocationValid(userPreferences.getLocation())) {
            throw new IllegalArgumentException("A location can only contain characters.");
        }

        // Save the user preferences
        UserPreferences result = repository.save(userPreferences);
        return result;
    }

    public boolean isLocationValid(String location) {
        if (location == null) {
            return false;
        }

        // Make sure the location only contains characters
        if(!containsOnlyAlphabetCharacters(location)){
            return false;
        }

        return true;
    }

    public boolean containsOnlyAlphabetCharacters(String location) {
        // Regular expression pattern to match only alphabet characters
        String regex = "^[a-zA-Z]+$";
        return location.matches(regex);
    }

    public UserPreferences updateUserPreferences(UserPreferences existingPreferences) {
        UserPreferences updatedPreferences = repository.save(existingPreferences);

        return updatedPreferences;
    }

    public void deleteUserPreferences(UserPreferences existingPreferences) {
        repository.delete(existingPreferences);
    }

}
