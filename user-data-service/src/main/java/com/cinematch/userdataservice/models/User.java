package com.cinematch.userdataservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
    private @Id @GeneratedValue Long id;

    @NotBlank(message = "First name is required")
    @Size(max = 30, message = "First name can be at most 30 characters long")
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Size(max = 50, message = "Last name can be at most 50 characters long")
    private String lastName;

    @NotBlank(message = "Email is required")
    @Size(max = 50, message = "Email can be at more 50 characters long")
    @Email(message = "Email should be valid")
    private String email;

    @Size(max = 25, message = "Display name can be at most 25 characters long")
    private String displayName;
    
    @Size(max = 100, message = "Profile picture URL can be at most 100 characters long")
    private String profilePicture;

    public Long getId() {
        return id;
    }
    public void setUserId(Long userId) {
        this.id = userId;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getDisplayName() {
        return displayName;
    }
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
    public String getProfilePicture() {
        return profilePicture;
    }
    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public User() {
        
    }

    public User(String firstName, String lastName, String email, String displayName, String profilePicture) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.displayName = displayName;
        this.profilePicture = profilePicture;
    }
}
