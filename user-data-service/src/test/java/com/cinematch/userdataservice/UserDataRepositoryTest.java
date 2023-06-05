package com.cinematch.userdataservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.cinematch.userdataservice.models.User;
import com.cinematch.userdataservice.repositories.UserRepository;

public class UserDataRepositoryTest {
    
    private UserRepository repository;

    @BeforeEach
    void setup() {
        repository = Mockito.mock(UserRepository.class);
    }

    @Test
    void return_one_user() {
        // Given
        User user = new User();
        user.setFirstName("Emma");
        user.setLastName("Watson");

        // Define behavior for mocked repository methods
        Mockito.when(repository.save(user)).thenReturn(user);
        Mockito.when(repository.findByFirstName("Emma")).thenReturn(user);

        // When
        User foundUser = repository.findByFirstName("Emma");

        // Then
        assertNotNull(foundUser);
        assertEquals("Emma", foundUser.getFirstName());
    }
}
