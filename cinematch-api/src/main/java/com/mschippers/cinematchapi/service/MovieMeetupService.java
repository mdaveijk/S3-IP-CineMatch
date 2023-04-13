package com.mschippers.cinematchapi.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mschippers.cinematchapi.model.MovieMeetup;

@Service
public class MovieMeetupService {
    
    private List<MovieMeetup> meetupList;

    public MovieMeetupService() {
        meetupList = new ArrayList<>();

        MovieMeetup meetup1 = new MovieMeetup(1L, "Boys Night Out", LocalDate.now(), "Nijmegen");
        MovieMeetup meetup2 = new MovieMeetup(2L, "Girls Night Out", LocalDate.now(), "Eindhoven");
        MovieMeetup meetup3 = new MovieMeetup(3L, "Polka Party", LocalDate.now(), "New York");
        MovieMeetup meetup4 = new MovieMeetup(4L, "Movie Marathon", LocalDate.now(), "Seoul");
        MovieMeetup meetup5 = new MovieMeetup(5L, "Fright Nights", LocalDate.now(), "Amsterdam");

        meetupList.addAll(Arrays.asList(meetup1, meetup2, meetup3, meetup4, meetup5));
    }

    public MovieMeetup getMeetup(Long id)
    {
        for(MovieMeetup meetup : meetupList) {
            if(id == meetup.getId())
            {
                return meetup;
            }
        }
        return null;
    }
    // private final MovieMeetupRepository movieMeetupRepository; //Final is equal to "sealed" in C#
    
    // public MovieMeetupService(MovieMeetupRepository movieMeetupRepository) {
    //     this.movieMeetupRepository = movieMeetupRepository;
    // }
    
    // public List<MovieMeetup> getAllMovieMeetups() {
    //     return movieMeetupRepository.findAll();
    // }
}

