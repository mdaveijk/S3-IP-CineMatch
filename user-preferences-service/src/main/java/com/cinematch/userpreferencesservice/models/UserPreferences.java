package com.cinematch.userpreferencesservice.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class UserPreferences {
    @Id
    private Long userId;

    //This would have been done through polymorphism in a normal scenario.
    private List<MoviePreference> moviePreferences;
    
    private List<GenrePreference> genrePreferences;

    
    private String location;

    public Long getUserId() {
        return userId;
    }
    
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    public List<MoviePreference> getMoviePreferences() {
        return moviePreferences;
    }

    public void setMoviePreferences(List<MoviePreference> moviePreferences) {
        this.moviePreferences = moviePreferences;
    }

    public List<GenrePreference> getGenrePreferences() {
        return genrePreferences;
    }

    public void setGenrePreferences(List<GenrePreference> genrePreferences) {
        this.genrePreferences = genrePreferences;
    }

    public String getLocation() {
        return location;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }
    
    public UserPreferences() {
        
    }

    public UserPreferences(Long userId, List<MoviePreference> moviePreferences, List<GenrePreference> genrePreferences,
        String location) {
    this.userId = userId;
    this.moviePreferences = moviePreferences;
    this.genrePreferences = genrePreferences;
    this.location = location;
    }

}
