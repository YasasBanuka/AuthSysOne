package com.webdynamo.AuthSysOne;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This is the main entry point of the Spring Boot application.
 *
 * @SpringBootApplication is a convenience annotation that adds all of the following:
 * - @Configuration: Tags the class as a source of bean definitions for the application context.
 * - @EnableAutoConfiguration: Tells Spring Boot to start adding beans based on classpath settings, other beans, and various property settings.
 * - @ComponentScan: Tells Spring to look for other components, configurations, and services in the 'com.webdynamo.AuthSysOne' package, letting it find the controllers.
 */
@SpringBootApplication
public class AuthSysOneApplication {

	public static void main(String[] args) {
		// SpringApplication.run() method launches the application.
		// It sets up the default configuration, starts the Spring application context, and performs the class path scan.
		SpringApplication.run(AuthSysOneApplication.class, args);
	}

}
