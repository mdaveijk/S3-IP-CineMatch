package com.cinematch.userpreferencesservice.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @Type(value = MoviePreference.class, name = "movie"),
        @Type(value = GenrePreference.class, name = "genre")
})
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
