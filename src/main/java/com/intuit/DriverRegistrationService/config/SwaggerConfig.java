package com.intuit.DriverRegistrationService.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI usersMicroserviceOpenAPI() {
        OpenAPI info;
        info = new OpenAPI()
                .info(new Info().title("Driver Registration Service")
                        .description("Exposing APIs to onboard Driver to Ride Management Service")
                        .version("1.0"));
        return info;
    }
}


