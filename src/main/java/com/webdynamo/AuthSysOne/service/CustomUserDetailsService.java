package com.webdynamo.AuthSysOne.service;

import com.webdynamo.AuthSysOne.model.Users;
import com.webdynamo.AuthSysOne.repository.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Custom implementation of UserDetailsService.
 * This service is used by Spring Security to load user-specific data during authentication.
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepo userRepo;

    public CustomUserDetailsService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    /**
     * Loads the user by username from the database.
     *
     * @param username The username identifying the user whose data is required.
     * @return A fully populated UserDetails object (contains username, password, authorities).
     * @throws UsernameNotFoundException if the user could not be found.
     */
    @Override
    public UserDetails loadUserByUsername(String username){

        // 1. Find the user in our database
        Users user = userRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        // 2. Map our 'Users' entity to Spring Security's 'UserDetails'
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .authorities("USER") // Assign a default role/authority
                .build();
    }
}
