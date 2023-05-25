package com.cinematch.userpreferencesservice.models;

import java.util.List;

public abstract class Preference {
    private List<String> name;

    public List<String> getName() {
        return name;
    }

    public void setName(List<String> name) {
        this.name = name;
    }

    public Preference() {
        
    }

    public Preference(List<String> name) {
        this.name = name;
    }
}
