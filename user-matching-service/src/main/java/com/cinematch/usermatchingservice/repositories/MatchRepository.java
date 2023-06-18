package com.cinematch.usermatchingservice.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.repository.query.Param;

import com.cinematch.usermatchingservice.enums.Status;
import com.cinematch.usermatchingservice.models.Match;

@EnableMongoRepositories
public interface MatchRepository extends MongoRepository<Match, String> {

    List<Match> findByStatus(Status status);
    
    Optional<Match> findById(@Param("id") String id);

    Match findByUserId1InAndUserId2In(int userId1, int userId2);

}
