package com.cinematch.usermatchingservice.controllers;

import java.net.URISyntaxException;
import java.util.Collection;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cinematch.usermatchingservice.enums.Status;
import com.cinematch.usermatchingservice.models.Match;
import com.cinematch.usermatchingservice.repositories.MatchRepository;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/matches")
@CrossOrigin(origins = "http://localhost:5173/")
public class MatchController {
    
    private MatchRepository matchRepository;

    public MatchController(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }
    
    //Brief summary of the endpoint
    @Operation(summary = "Get a list of all matches.")
    @GetMapping
    Collection<Match> matches() {
        return (Collection<Match>) matchRepository.findAll();
    }

    @Operation(summary = "Get a particular match by its id.")
    @GetMapping("/{id}")
    ResponseEntity<Match> findById(@PathVariable String id)
    {
        try {
            Match result = matchRepository.findById(id);
            if (result != null) {
                return ResponseEntity.ok().body(result);
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Match Not Found");
            }
        } catch (Exception e) {
           //Other exceptions that might occur
           //TODO handle this try ... catch block in a better way.
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Operation(summary = "Get a list of matches that have a particular status.")
    @GetMapping("/status/{status}")
    public ResponseEntity<List<Match>> findByStatus(@PathVariable("status") Status status) {
        List<Match> matches = matchRepository.findByStatus(status);
        return ResponseEntity.ok(matches);
    }

    @PostMapping
    ResponseEntity<Match> createMatch(@Validated @RequestBody Match match) throws URISyntaxException {
        Match result = matchRepository.save(match);
        return ResponseEntity.ok().body(result);
    }
}
