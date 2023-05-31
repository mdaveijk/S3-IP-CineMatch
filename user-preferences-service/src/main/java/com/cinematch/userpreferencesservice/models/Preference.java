package com.cinematch.userpreferencesservice.models;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @Type(value = MoviePreference.class, name = "movie"),
        @Type(value = GenrePreference.class, name = "genre")
})
public abstract class Preference {

    protected Preference() {

    }

}
