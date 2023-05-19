package com.cinematch.usermatchingservice.controllers;

import java.net.URISyntaxException;
import java.util.Collection;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cinematch.usermatchingservice.models.Match;
import com.cinematch.usermatchingservice.repositories.MatchRepository;

@RestController
@RequestMapping("/matches")
public class MatchController {
    
    private MatchRepository matchRepository;

    public MatchController(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    @GetMapping("/{id}")
    ResponseEntity<Match> getMatchById(@PathVariable String id)
    {
        Match result = matchRepository.findById(id);
        if(result != null)
        {
            return ResponseEntity.ok().body(result);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    Collection<Match> matches() {
        return (Collection<Match>) matchRepository.findAll();
    }

    @PostMapping
    ResponseEntity<Match> createMatch(@Validated @RequestBody Match match) throws URISyntaxException {
        Match result = matchRepository.save(match);
        return ResponseEntity.ok().body(result);
    }
}
