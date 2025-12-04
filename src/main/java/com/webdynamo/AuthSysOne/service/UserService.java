package com.webdynamo.AuthSysOne.service;

import com.webdynamo.AuthSysOne.model.Users;
import com.webdynamo.AuthSysOne.repository.UserRepo;
import org.springframework.stereotype.Service;

/**
 * Service class that holds the business logic for User operations.
 *
 * @Service: Marks this class as a service provider. Spring detects it during classpath scanning
 * and registers it as a bean in the application context.
 */
@Service
public class UserService {

    private final UserRepo userRepo;

    /**
     * Constructor Injection: Spring automatically injects the UserRepo bean into this constructor.
     * This is the preferred way of dependency injection in Spring.
     *
     * @param userRepo The repository for user data access.
     */
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    // REGISTER
    /**
     * Registers a new user with the given username and password.
     *
     * @param username The username of the new user.
     * @param password The password of the new user.
     * @return The saved User entity.
     * @throws RuntimeException if the username already exists.
     */
    public Users register(String username, String password) {

        // Check if the username already exists in the database
        if(userRepo.findByUsername(username).isPresent()){
            throw new RuntimeException("Username already exists");
        }

        // Create a new User entity
        Users user = new Users();
        user.setUsername(username);
        user.setPassword(password); // Note: In a real app, passwords should be hashed before saving!

        // Save the user to the database
        return userRepo.save(user);
    }

    // LOGIN
    /**
     * Authenticates a user with the given username and password.
     *
     * @param username The username provided by the user.
     * @param password The password provided by the user.
     * @return true if authentication is successful, false otherwise.
     * @throws RuntimeException if the username is not found.
     */
    public boolean login(String username, String password) {
        // Find the user by username, or throw an exception if not found
        Users user = userRepo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Username not found"));

        // Check if the provided password matches the stored password
        // Note: In a real app, you would compare hashed passwords.
        return user.getPassword().equals(password);
    }
}
