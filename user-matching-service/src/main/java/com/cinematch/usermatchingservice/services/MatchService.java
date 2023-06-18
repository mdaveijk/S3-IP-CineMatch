package com.cinematch.usermatchingservice.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cinematch.usermatchingservice.enums.Status;
import com.cinematch.usermatchingservice.models.Match;
import com.cinematch.usermatchingservice.repositories.MatchRepository;

@Service
public class MatchService {

    private MatchRepository matchRepository;

    public MatchService(MatchRepository repository) {
        this.matchRepository = repository;
    }

    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }

    public Match findMatchByUserIds(int userId1, int userId2) {
        return matchRepository.findByUserId1InAndUserId2In(userId1, userId2);
    }


    public Match createMatch(Match match) {
        if (doesMatchExist(match) == null) {
            return matchRepository.save(match);
        }
        return null;
    }


    public Match updateMatch(Match match) {
        Match existingMatch = doesMatchExist(match);

        if (existingMatch != null) {
            // Check if any changes are made
            boolean hasChanges = false;

            if (!match.getMatchCriteria().equals(existingMatch.getMatchCriteria())) {
                existingMatch.setMatchCriteria(match.getMatchCriteria());
                hasChanges = true;
            }

            if (match.getStatus() != existingMatch.getStatus()) {
                existingMatch.setStatus(match.getStatus());
                hasChanges = true;
            }

            // Perform the update if changes are made
            if (hasChanges) {
                return matchRepository.save(existingMatch);
            } else {
                // Return the existing match if no changes are made
                return existingMatch;
            }
        }

        return null;
    }

    public boolean deleteMatch(int userId1, int userId2) {
        Match match = doesMatchExist(userId1, userId2);

        if (match != null) {
            matchRepository.delete(match);
            return true;
        }
        return false;
    }

    public Match doesMatchExist(Match match) {
        Match existingMatch = matchRepository.findByUserId1InAndUserId2In(match.getUserId1(), match.getUserId2());

        if (existingMatch != null) {
            return existingMatch;
        }

        return null;
    }

    public Match doesMatchExist(int userId1, int userId2) {
        Match existingMatch = matchRepository.findByUserId1InAndUserId2In(userId1, userId2);

        if (existingMatch != null) {
            return existingMatch;
        }

        return null;
    }

    public List<Match> findMatchesByStatus(Status status) {
        return this.matchRepository.findByStatus(status);
    }

}
