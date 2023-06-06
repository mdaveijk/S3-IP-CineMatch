package com.cinematch.userpreferencesservice.models;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("genre")
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

    public GenrePreference(String genre) {
        this.genre = genre;
    }
}
