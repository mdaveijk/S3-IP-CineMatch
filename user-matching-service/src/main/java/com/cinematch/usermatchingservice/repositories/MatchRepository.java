package com.cinematch.usermatchingservice.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.repository.query.Param;

import com.cinematch.usermatchingservice.enums.Status;
import com.cinematch.usermatchingservice.models.Match;

@EnableMongoRepositories
public interface MatchRepository extends MongoRepository<Match, Long> {

    List<Match> findByStatus(Status status);
    
    Match findById(@Param("id") String id);

    List<Match> findAllByUserId(int userId);
}
