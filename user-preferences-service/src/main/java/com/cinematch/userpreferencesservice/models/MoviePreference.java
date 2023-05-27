package com.cinematch.userpreferencesservice.models;

import java.util.List;

public class MoviePreference extends Preference {

    private String title;

    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    public MoviePreference(List<String> preferences, String title) {
        super(preferences);
        this.title = title;
    }


    public MoviePreference(List<String> name) {
        super(name);

    }
    
}
