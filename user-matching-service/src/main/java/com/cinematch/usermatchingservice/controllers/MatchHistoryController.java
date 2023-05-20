package com.cinematch.usermatchingservice.controllers;

import java.net.URISyntaxException;
import java.util.Collection;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cinematch.usermatchingservice.models.MatchHistory;
import com.cinematch.usermatchingservice.repositories.MatchHistoryRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/matches/history")
@CrossOrigin(origins = "http://localhost:5173/")
public class MatchHistoryController {
    
    private MatchHistoryRepository historyRepository;

    public MatchHistoryController(MatchHistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }
    
    //Brief summary of the endpoint
    @Operation(summary = "Get a list of the history of all matches.")
    @GetMapping
    Collection<MatchHistory> matchHistories() {
        return (Collection<MatchHistory>) historyRepository.findAll();
    }

    @PostMapping
    ResponseEntity<MatchHistory> createMatchHistory(@Validated @RequestBody MatchHistory history) throws URISyntaxException {
        MatchHistory result = historyRepository.save(history);
        return ResponseEntity.ok().body(result);
    }
}
