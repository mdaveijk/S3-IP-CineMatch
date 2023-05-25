package com.cinematch.userpreferencesservice.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class UserPreferences {
    @Id
    private Long userId;

    // @DocumentReference
    // private List<Preference> preferences;
    private List<String> preferences;

    private String location;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<String> getPreferences() {
        return preferences;
    }

    public void setPreferences(List<String> preferences) {
        this.preferences = preferences;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public UserPreferences() {
        
    }

    public UserPreferences(Long id, List<String> preferences, String location) {
        this.userId = id;
        this.preferences = preferences;
        this.location = location;
    }
}
