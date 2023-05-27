package com.cinematch.userpreferencesservice.models;

import java.util.List;

public class GenrePreference extends Preference {
    
    private String genre;
    
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    
    
    public GenrePreference() {
        super();
    }

    public GenrePreference(List<String> preferences, String genre) {
        super(preferences);
        this.genre = genre;
    }
}
