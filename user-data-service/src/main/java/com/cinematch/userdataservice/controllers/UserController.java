package com.cinematch.userdataservice.controllers;

import com.cinematch.userdataservice.models.User;
import com.cinematch.userdataservice.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Get a list of all users.")
    @GetMapping
    @ApiResponse(responseCode = "200", description = "Successfully found all the users.")
    @ApiResponse(responseCode = "204", description = "The list is empty, there are no users.")
    public ResponseEntity<Collection<User>> users() {
        Collection<User> users = userService.getAllUsers();

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
        Optional<User> result = userService.getUserById(id);
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
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User result = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @Operation(summary = "Update an existing user.")
    @PutMapping("/{id}")
    @ApiResponse(responseCode = "200", description = "Successfully updated the user.")
    @ApiResponse(responseCode = "404", description = "User not found.")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @Valid @RequestBody User updatedUser) {
        User result = userService.updateUser(id, updatedUser);
        if (result != null) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.notFound().header("Description", "No user with id " + id + " could be found.").build();
        }
    }


    @Operation(summary = "Delete a user by their id.")
    @DeleteMapping("/{id}")
    @ApiResponse(responseCode = "204", description = "Successfully deleted the user.")
    @ApiResponse(responseCode = "404", description = "User not found.")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        Optional<User> optionalUser = userService.getUserById(id);
        if (optionalUser.isPresent()) {
            userService.deleteUser(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().header("Description", "No user with id " + id + " could be found.")
                    .build();
        }
    }
}