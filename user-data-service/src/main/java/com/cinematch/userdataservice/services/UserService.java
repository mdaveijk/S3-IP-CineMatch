package com.cinematch.userdataservice.services;

import com.cinematch.userdataservice.models.User;
import com.cinematch.userdataservice.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Working with Optional<> for the UserDataService.
    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    public User createUser(User user) {

        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            return null; // User with the same email already exists
        }

        if (!containsOnlyAlphabetCharacters(user.getFirstName())) {
            return null; // First name contains invalid characters
        }

        if (!containsOnlyAlphabetCharacters(user.getLastName())) {
            return null; // Last name contains invalid characters
        }

        return userRepository.save(user);
    }

    public User updateUser(Long id, User updatedUser) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setFirstName(updatedUser.getFirstName());
            user.setLastName(updatedUser.getLastName());
            user.setEmail(updatedUser.getEmail());
            user.setDisplayName(updatedUser.getDisplayName());
            user.setProfilePicture(updatedUser.getProfilePicture());
            return userRepository.save(user);
        }
        return null;
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    private boolean containsOnlyAlphabetCharacters(String name) {
        // Regular expression pattern to match only alphabet characters
        String regex = "^[a-zA-Z]+$";
        return name.matches(regex);
    }
}
