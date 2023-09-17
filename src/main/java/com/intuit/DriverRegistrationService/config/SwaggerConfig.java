package com.intuit.DriverRegistrationService.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for Swagger documentation.
 * This class sets up the Swagger documentation for the "Driver Registration Service" module
 * of the application, providing metadata about the service.
 */
@Configuration
public class SwaggerConfig {

    /**
     * Defines the Swagger OpenAPI documentation for the Driver Registration Service.
     *
     * @return An OpenAPI object containing metadata about the service.
     */
    @Bean
    public OpenAPI usersMicroserviceOpenAPI() {
        // Create an instance of OpenAPI and configure its metadata
        OpenAPI info;
        info = new OpenAPI()
                .info(new Info().title("Driver Registration Service")
                        .description("Exposing APIs to onboard Driver to Ride Management Service")
                        .version("1.0"));
        return info;
    }
}


