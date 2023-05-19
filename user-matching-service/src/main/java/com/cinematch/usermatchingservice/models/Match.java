package com.cinematch.usermatchingservice.models;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.cinematch.usermatchingservice.enums.Status;


@Document(collection = "matches")
public class Match {
    
    @Id
    private String id;

    private int userId1;
    private int userId2;
    
    @DBRef
    private List<Preference> matchCriteria;
    
    @Field
    private Status status;

    public int getUserId1() {
        return userId1;
    }
    
    public void setUserId1(int userId1) {
        this.userId1 = userId1;
    }
    
    public int getUserId2() {
        return userId2;
    }
    
    public void setUserId2(int userId2) {
        this.userId2 = userId2;
    }
    
    public List<Preference> getMatchCriteria() {
        return matchCriteria;
    }
    
    public void setMatchCriteria(List<Preference> matchCriteria) {
        this.matchCriteria = matchCriteria;
    }
    
    public Status getStatus() {
        return status;
    }
    
    public void setStatus(Status status) {
        this.status = status;
    }
    
    public Match() {} //Empty constructor to allow Spring Data to create new resources
    
    public Match(int userId1, int userId2, Status status) {
        this.userId1 = userId1;
        this.userId2 = userId2;
        this.status = status;
    }

    // public Match(int userId1, int userId2, List<Preference> matchCriteria, Status status) {
    //     this.userId1 = userId1;
    //     this.userId2 = userId2;
    //     this.matchCriteria = matchCriteria;
    //     this.status = status;
    // }
}
