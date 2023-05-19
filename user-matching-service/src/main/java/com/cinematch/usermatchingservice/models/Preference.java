package com.cinematch.usermatchingservice.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Preference {


    @Id
    private String name; //name of preference
    
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Preference() { }
    
    public Preference(String name) {
        this.name = name;
    }
    
}
