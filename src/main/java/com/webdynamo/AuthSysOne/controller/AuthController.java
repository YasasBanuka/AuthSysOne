package com.webdynamo.AuthSysOne.controller;

import com.webdynamo.AuthSysOne.dto.LoginRequest;
import com.webdynamo.AuthSysOne.dto.RegisterRequest;
import com.webdynamo.AuthSysOne.model.Users;
import com.webdynamo.AuthSysOne.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

/**
 * REST Controller for handling authentication-related HTTP requests.
 *
 * @RestController: Combines @Controller and @ResponseBody.
 * It indicates that this class handles web requests and the return values of methods
 * are written directly to the HTTP response body (as JSON/XML).
 *
 * @RequestMapping("/auth"): Maps all HTTP requests starting with "/auth" to this controller.
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;

    /**
     * Constructor Injection for dependencies.
     * We inject UserService for user registration and AuthenticationManager for login.
     */
    public AuthController(UserService userService, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
    }

    /**
     * Handles HTTP POST requests to "/auth/register".
     *
     * @PostMapping("/register"): Maps POST requests to the register method.
     * @RequestBody: Maps the HTTP request body (JSON) to the RegisterRequest DTO.
     *
     * @param registerRequest The user data (username, password) sent in the request body.
     * @return A success message.
     */
    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest registerRequest) {
        userService.register(
                registerRequest.getUsername(),
                registerRequest.getPassword()
        );
        return "User registered successfully";
    }

    /**
     * Handles HTTP POST requests to "/auth/login".
     * This endpoint authenticates a user using Spring Security's AuthenticationManager.
     *
     * @param loginRequest The user credentials (username and password) sent in the request body.
     * @return A success or failure message.
     */
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {

        // 1. Create an authentication token with the provided username and password.
        // This token is unauthenticated at this point.
        UsernamePasswordAuthenticationToken authToken =
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                );

        // 2. Delegate authentication to the AuthenticationManager.
        // It will use the UserDetailsService to load the user and check the password.
        // If successful, it returns a fully authenticated Authentication object.
        Authentication auth = authenticationManager.authenticate(authToken);

        // 3. Check if authentication was successful.
        if (auth.isAuthenticated()) {
            return "User logged in successfully";
        }
        return "Login Failed";
    }

    @GetMapping("/test")
    public String secured() {
        return "You are authenticated";
    }
}
