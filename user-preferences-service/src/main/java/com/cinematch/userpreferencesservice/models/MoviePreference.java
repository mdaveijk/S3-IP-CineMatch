package com.cinematch.userpreferencesservice.models;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("movie")
public class MoviePreference extends Preference {

    private String title;

    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    public MoviePreference(String title) {
        this.title = title;
    }


    public MoviePreference() {
        super();
    }
    
}
