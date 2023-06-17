package com.cinematch.userdataservice.controllers;

import java.util.Collection;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cinematch.userdataservice.models.User;
import com.cinematch.userdataservice.repositories.UserRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:5173/")
public class UserController {

    private UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    // Brief summary of the endpoint
    @Operation(summary = "Get a list of all users.")
    @GetMapping
    @ApiResponse(responseCode = "200", description = "Successfully found all the users.")
    @ApiResponse(responseCode = "204", description = "The list is empty, there are no users.")
    public ResponseEntity<Collection<User>> users() {
        Collection<User> users = repository.findAll();

        if (users.isEmpty()) {
            return ResponseEntity.noContent().header("Description", "There are no users.").build();
        }

        return ResponseEntity.ok(users);
    }

    @Operation(summary = "Get a particular user by their id.")
    @GetMapping("/{id}")
    @ApiResponse(responseCode = "200", description = "Successfully found the user.")
    @ApiResponse(responseCode = "404", description = "User not found.")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        Optional<User> result = repository.findById(id);
        if (result.isPresent()) {
            return ResponseEntity.ok(result.get());
        } else {
            return ResponseEntity.notFound().header("Description", "No user with id " + id + " could be found.")
                    .build();
        }
    }

    @Operation(summary = "Create a new user.")
    @PostMapping
    @ApiResponse(responseCode = "201", description = "Successfully created a new user.")
    @ApiResponse(responseCode = "400", description = "Some of the data entered is wrong.")
    public ResponseEntity<User> createUser(@Validated @RequestBody User user) {
        User result = repository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @Operation(summary = "Update an existing user.")
    @PutMapping("/{id}")
    @ApiResponse(responseCode = "200", description = "Successfully updated the user.")
    @ApiResponse(responseCode = "404", description = "User not found.")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @Validated @RequestBody User updatedUser) {
        Optional<User> optionalUser = repository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setFirstName(updatedUser.getFirstName());
            user.setLastName(updatedUser.getLastName());
            user.setEmail(updatedUser.getEmail());
            user.setDisplayName(updatedUser.getDisplayName());
            user.setProfilePicture(updatedUser.getProfilePicture());
            User result = repository.save(user);
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.notFound().header("Description", "No user with id " + id + " could be found.")
                    .build();
        }
    }

    @Operation(summary = "Delete a user by their id.")
    @DeleteMapping("/{id}")
    @ApiResponse(responseCode = "204", description = "Successfully deleted the user.")
    @ApiResponse(responseCode = "404", description = "User not found.")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        Optional<User> optionalUser = repository.findById(id);
        if (optionalUser.isPresent()) {
            repository.delete(optionalUser.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().header("Description", "No user with id " + id + " could be found.")
                    .build();
        }
    }
}
