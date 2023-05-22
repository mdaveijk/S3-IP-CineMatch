package com.cinematch.usermatchingservice.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.repository.query.Param;

import com.cinematch.usermatchingservice.models.MatchHistory;

@EnableMongoRepositories
public interface MatchHistoryRepository extends MongoRepository<MatchHistory, Long> {

    List<MatchHistory> findByUserId1(@Param("id") int userId1);
    
}
