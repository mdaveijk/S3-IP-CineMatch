package com.mschippers.cinematchapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mschippers.cinematchapi.model.MovieMeetup;
import com.mschippers.cinematchapi.service.MovieMeetupService;

@RestController
@RequestMapping("/api/movie-meetups")
public class MovieMeetupController {
    
    private final MovieMeetupService movieMeetupService;
    
    @Autowired
    public MovieMeetupController(MovieMeetupService movieMeetupService) {
        this.movieMeetupService = movieMeetupService;
    }
    
    @CrossOrigin(origins = "http://127.0.0.1:5173")
    @GetMapping
    public MovieMeetup getMeetup(@RequestParam Long id)
    {
        return movieMeetupService.getMeetup(id);
    }
    /* 
    @GetMapping
    public List<MovieMeetup> getAllMovieMeetups() {
        return movieMeetupService.getAllMovieMeetups();
    } 
    */
}
