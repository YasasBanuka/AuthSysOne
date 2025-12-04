package com.webdynamo.AuthSysOne.controller;

import com.webdynamo.AuthSysOne.model.Users;
import com.webdynamo.AuthSysOne.service.UserService;
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

    /**
     * Constructor Injection for UserService.
     */
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Handles HTTP POST requests to "/auth/register".
     *
     * @PostMapping("/register"): Maps POST requests to the register method.
     * @RequestBody: Maps the HTTP request body (JSON) to the Users object.
     *
     * @param users The user data sent in the request body.
     * @return The registered User object.
     */
    @PostMapping("/register")
    public Users register(@RequestBody Users users) {
        return userService.register(
                users.getUsername(),
                users.getPassword()
        );
    }

    /**
     * Handles HTTP POST requests to "/auth/login".
     * This endpoint is used to authenticate an existing user.
     *
     * @PostMapping("/login"): Maps POST requests to the login method.
     * @RequestBody: Maps the HTTP request body to the Users object.
     *
     * @param users The user credentials (username and password) sent in the request body.
     * @return A success or failure message based on the authentication result.
     */
    @PostMapping("/login")
    public String login(@RequestBody Users users) {
        boolean success = userService.login(
                users.getUsername(),
                users.getPassword()
        );
        return success ? "Login Success" : "Login Fail";
    }
}
