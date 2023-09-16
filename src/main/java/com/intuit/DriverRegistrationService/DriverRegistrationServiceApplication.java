package com.intuit.DriverRegistrationService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The main application class for the Driver Registration Service.
 * This class serves as the entry point for the application and is responsible for starting the Spring Boot application.
 */
@SpringBootApplication
public class DriverRegistrationServiceApplication {

	/**
	 * The main method that starts the Spring Boot application.
	 *
	 * @param args Command-line arguments (if any) passed to the application.
	 */
	public static void main(String[] args) {
		SpringApplication.run(DriverRegistrationServiceApplication.class, args);
	}

}
