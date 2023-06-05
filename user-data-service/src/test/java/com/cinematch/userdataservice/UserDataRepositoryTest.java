package com.cinematch.userdataservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cinematch.userdataservice.models.User;
import com.cinematch.userdataservice.repositories.UserRepository;

@SpringBootTest(classes = UserDataServiceApplication.class)
public class UserDataRepositoryTest {
    
    @Autowired
    private UserRepository repository;

    @Test
    public void givenUserRepository_whenSaveAndRetreiveEntity_thenOK() {
        User user = repository
          .save(new User("test firstname", "test lastname", "test email", "test displayname"
          , "someurl.jpg"));
        User foundUser = repository
          .findOne(user.getId());
 
        assertNotNull(foundUser);
        assertEquals(user.getFirstName(), foundUser.getFirstName());
    }
}
