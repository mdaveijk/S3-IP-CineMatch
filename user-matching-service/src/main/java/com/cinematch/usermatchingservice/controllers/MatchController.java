package com.cinematch.usermatchingservice.controllers;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cinematch.usermatchingservice.enums.Status;
import com.cinematch.usermatchingservice.models.Match;
import com.cinematch.usermatchingservice.repositories.MatchRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/api/matches")
@CrossOrigin(origins = "http://localhost:5173/")
public class MatchController {

    private MatchRepository matchRepository;

    public MatchController(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    // Brief summary of the endpoint
    @Operation(summary = "Get a list of all matches.")
    @GetMapping
    @ApiResponse(responseCode = "200", description = "Successfully found all the matches.")
    @ApiResponse(responseCode = "204", description = "The list is empty, there are no matches.")
    public ResponseEntity<Collection<Match>> matches() {
        Collection<Match> matches = matchRepository.findAll();

        if (matches.isEmpty()) {
            // As noContent() does not support adding information, I'm adding it to the
            // header instead.
            return ResponseEntity.noContent().header("Description", "There are no matches at the moment.").build();
        }

        return ResponseEntity.ok(matches);
    }

    @Operation(summary = "Get a particular match by its id.")
    @GetMapping("/{id}")
    // Possible responses (this will be shown in the documentation)
    @ApiResponse(responseCode = "200", description = "Successfully found the match")
    @ApiResponse(responseCode = "404", description = "Match not found")
    ResponseEntity<Match> findById(@PathVariable String id) {
        Optional<Match> result = matchRepository.findById(id);
        if (result.isPresent()) {
            return ResponseEntity.ok(result.get());
        } else {
            return ResponseEntity.notFound().header("Description", "No match with id " + id + " could be found.")
                    .build();
        }
    }

    @Operation(summary = "Get a list of matches by a particular status.")
    @GetMapping("/status/{status}")
    @ApiResponse(responseCode = "200", description = "Successfully found matches that match this status.")
    @ApiResponse(responseCode = "400", description = "Bad request: No such status type exists.")
    public ResponseEntity<List<Match>> findByStatus(@PathVariable("status") Status status) {
        List<Match> matches = matchRepository.findByStatus(status);
        return ResponseEntity.ok(matches);
    }

    @Operation(summary = "Create a new match between users.")
    @PostMapping
    @ApiResponse(responseCode = "201", description = "Successfully created a match.")
    @ApiResponse(responseCode = "400", description = "Some of the data entered is wrong.")
    ResponseEntity<Match> createMatch(@Validated @RequestBody Match match) {
        Match result = matchRepository.save(match);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @Operation(summary = "Update an existing match.")
    @PutMapping()
    @ApiResponse(responseCode = "200", description = "Successfully updated the match.")
    @ApiResponse(responseCode = "404", description = "Match not found.")
    public ResponseEntity<Match> updateMatch(@RequestParam("userId1") int userId1, @RequestParam("userId2") int userId2,
            @Validated @RequestBody Match updatedMatch) {
        Match match = matchRepository.findByUserId1InAndUserId2In(userId1, userId2);
        if (match != null) {
            // Update the fields of the existing match with the new values
            match.setMatchCriteria(updatedMatch.getMatchCriteria());
            match.setStatus(updatedMatch.getStatus());
            Match result = matchRepository.save(match);
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.notFound()
                    .header("Description",
                            "No match between users with ids " + userId1 + " and " + userId2 + " could be found.")
                    .build();
        }
    }

    @Operation(summary = "Delete a match by user IDs.")
    @DeleteMapping()
    @ApiResponse(responseCode = "204", description = "Successfully deleted the match.")
    @ApiResponse(responseCode = "404", description = "Match not found.")
    public ResponseEntity<Void> deleteMatch(@RequestParam("userId1") int userId1, @RequestParam("userId2") int userId2) {
        Match match = matchRepository.findByUserId1InAndUserId2In(userId1, userId2);
        if (match != null) {
            matchRepository.delete(match);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound()
                    .header("Description",
                            "No match between users with ids " + userId1 + " and " + userId2 + " could be found.")
                    .build();
        }
    }


}
