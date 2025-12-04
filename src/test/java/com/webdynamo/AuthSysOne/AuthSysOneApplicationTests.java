package com.webdynamo.AuthSysOne;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * This class contains integration tests for the application.
 *
 * @SpringBootTest: Tells Spring Boot to look for a main configuration class (one with @SpringBootApplication)
 * and use that to start a Spring application context.
 */
@SpringBootTest
class AuthSysOneApplicationTests {

	/**
	 * A simple sanity check test that will fail if the application context cannot start.
	 */
	@Test
	void contextLoads() {
	}

}
