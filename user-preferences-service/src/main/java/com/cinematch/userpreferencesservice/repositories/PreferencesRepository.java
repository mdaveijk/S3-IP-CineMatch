package com.cinematch.userpreferencesservice.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.cinematch.userpreferencesservice.models.UserPreferences;

@EnableMongoRepositories
public interface PreferencesRepository extends MongoRepository<UserPreferences, Long> {
    
}
