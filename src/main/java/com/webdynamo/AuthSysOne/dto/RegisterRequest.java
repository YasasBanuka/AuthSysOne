package com.webdynamo.AuthSysOne.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO (Data Transfer Object) for registration requests.
 * It carries the user registration data from the client to the server.
 *
 * Lombok Annotations:
 * @Data: Generates getters, setters, toString, equals, and hashCode.
 * @NoArgsConstructor: Generates a no-argument constructor.
 * @AllArgsConstructor: Generates a constructor with all arguments.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    private String username;
    private String password;
}
