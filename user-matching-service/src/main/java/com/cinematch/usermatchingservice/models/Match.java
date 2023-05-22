package com.cinematch.usermatchingservice.models;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.cinematch.usermatchingservice.enums.Status;


@Document(collection = "matches")
public class Match {
    
    @Id
    protected String id; //Match id

    protected int userId1;
    protected int userId2;
    
    protected List<String> matchCriteria;

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
    
    public List<String> getMatchCriteria() {
        return matchCriteria;
    }
    
    public void setMatchCriteria(List<String> matchCriteria) {
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
}
