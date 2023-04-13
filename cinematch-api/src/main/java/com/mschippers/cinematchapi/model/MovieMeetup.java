package com.mschippers.cinematchapi.model;

import java.time.LocalDate;
import java.util.List;

// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.ManyToMany;
// import jakarta.persistence.Table;

//@Entity
//@Table(name = "movie_meetup")
public class MovieMeetup {
 
    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
 
    //@Column(name = "name")
    private String name;
 
    //@Column(name = "date")
    private LocalDate date;
 
    //@Column(name = "location")
    private String location;
 
    //@ManyToMany(mappedBy = "movieMeetups")
    private List<User> participants;

    public MovieMeetup(Long id, String name, LocalDate date, String location) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.location = location;
    }

    public MovieMeetup(Long id, String name, LocalDate date, String location, List<User> participants) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.location = location;
        this.participants = participants;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public void setParticipants(List<User> participants) {
        this.participants = participants;
    }
 
    // Constructors, getters, and setters
}

