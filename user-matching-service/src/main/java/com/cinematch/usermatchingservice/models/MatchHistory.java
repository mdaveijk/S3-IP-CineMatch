package com.cinematch.usermatchingservice.models;

import java.time.LocalDate;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.cinematch.usermatchingservice.enums.Status;

//TODO fix this class. None of the fields are currently processed and all return 0 or null.
@Document(collection = "matcheshistory")
public class MatchHistory extends Match{

    @Field
    private LocalDate closeDate;

    public int getUserId1() {
        return userId1;
    }

    public LocalDate getCloseDate() {
        return closeDate;
    }
    
    public void setCloseDate(LocalDate closeDate) {
        this.closeDate = closeDate;
    }

    public MatchHistory() {
        super();
    }
    
    public MatchHistory(int userId1, int userId2, Status status, LocalDate closeDate) {
        super(userId1, userId2, status);
        this.closeDate = closeDate;
    }
}
