package com.cinematch.userdataservice;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cinematch.userdataservice.controllers.UserController;
import com.cinematch.userdataservice.models.User;
import com.cinematch.userdataservice.services.UserService;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void getAllUsersShouldReturnOK() throws Exception {
        User user1 = new User("John", "Doe", "john.doe@example.com", "JohnD", "https://example.com/profile1.jpg");
        User user2 = new User("Jane", "Smith", "jane.smith@example.com", "JaneS", "https://example.com/profile2.jpg");

        List<User> users = Arrays.asList(user1, user2);

        when(userService.getAllUsers()).thenReturn(users);

        mockMvc.perform(get("/api/users"))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void NoUsersShouldReturnNoContent() throws Exception {
        when(userService.getAllUsers()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/api/users"))
                .andExpect(status().isNoContent())
                .andReturn();
    }

    @Test
    public void createUserShouldReturnCreated() throws Exception {
        User user = new User("John", "Doe", "john.doe@example.com", "JohnD", "https://example.com/profile.jpg");

        when(userService.createUser(Mockito.any(User.class))).thenReturn(user);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                        "{\"firstName\":\"John\",\"lastName\":\"Doe\",\"email\":\"john.doe@example.com\",\"displayName\":\"JohnD\",\"profilePicture\":\"https://example.com/profile.jpg\"}"))
                .andExpect(status().isCreated())
                .andReturn();
    }

    @Test
    public void getUserByIdShouldReturnUser() throws Exception {
        Long userId = 1L;
        User user = new User("John", "Doe", "john.doe@example.com", "JohnD", "https://example.com/profile.jpg");
        Optional<User> testUser = Optional.of(user);

        when(userService.getUserById(userId)).thenReturn(testUser);

        mockMvc.perform(get("/api/users/{id}", userId))
                .andExpect(status().isOk())
                .andExpect(content().json(
                        "{\"firstName\":\"John\",\"lastName\":\"Doe\",\"email\":\"john.doe@example.com\",\"displayName\":\"JohnD\",\"profilePicture\":\"https://example.com/profile.jpg\"}"))
                .andReturn();
    }

    @Test
    public void updatePutUserShouldReturnOk() throws Exception {
        Long userId = 1L;
        User user = new User("John", "Doe", "john.doe@example.com", "JohnD", "https://example.com/profile.jpg");

        when(userService.updateUser(Mockito.eq(userId), Mockito.any(User.class))).thenReturn(user);

        mockMvc.perform(MockMvcRequestBuilders.put("/api/users/{id}", userId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                        "{\"firstName\":\"John\",\"lastName\":\"Doe\",\"email\":\"john.doe@example.com\",\"displayName\":\"JohnD\",\"profilePicture\":\"https://example.com/profile.jpg\"}"))
                .andExpect(status().isOk())
                .andReturn();
    }
}
