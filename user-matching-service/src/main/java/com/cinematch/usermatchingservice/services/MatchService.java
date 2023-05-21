package com.cinematch.usermatchingservice.services;

import java.util.List;

import org.apache.hc.core5.http.NotImplementedException;
import org.springframework.web.client.HttpServerErrorException.NotImplemented;

import com.cinematch.usermatchingservice.models.Match;
import com.cinematch.usermatchingservice.repositories.MatchRepository;

//TODO this entire class
public class MatchService {
    
    private List<Match> matches;
    private MatchRepository matchRepository;

    public MatchService(MatchRepository repository) {
        this.matchRepository = repository;
    }

    public List<Match> getAllMatchesByUser(int userId){
    // Retrieve the matches associated with the user from the data source
    
    List<Match> matches = matchRepository.findAllByUserId(userId);
    
    // Return the matches
    return matches;
    }

    //find out whether the proposed user has been rejected before
    public Boolean hasRejectedUserBefore(){
        return true;
    }

}
