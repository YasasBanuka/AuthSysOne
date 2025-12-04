package com.webdynamo.AuthSysOne.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Configuration class for application-wide beans.
 *
 * @Configuration: Indicates that this class declares one or more @Bean methods
 * and may be processed by the Spring container to generate bean definitions and
 * service requests for those beans at runtime.
 */
@Configuration
public class AppConfig {

    /**
     * Creates and configures the PasswordEncoder bean.
     * We use BCryptPasswordEncoder, which is a strong hashing function.
     * This bean will be injected into other components (like UserService)
     * to handle password hashing and verification.
     *
     * @return A new instance of BCryptPasswordEncoder.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
