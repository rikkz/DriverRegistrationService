package com.intuit.DriverRegistrationService.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * Configuration class for defining a Spring bean that provides a mapping of country codes to the
 * expected number of digits in their mobile numbers.
 * This configuration is used to validate mobile numbers based on their country code.
 */
@Configuration
public class CountryDigitsMapConfig {

    /**
     * Defines a Spring bean that maps country codes to the expected number of digits in their mobile numbers.
     * Modify this bean to include additional country codes and their corresponding digit counts as needed.
     *
     * @return A {@code Map} where keys are country codes (e.g., "+91" for India) and values are the expected number
     * of digits for mobile numbers in that country.
     */
    @Bean
    public Map<String, Integer> countryToDigitsMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("+91", 10); // India
        map.put("+44", 11); // UK
        // Add more countries as needed
        return map;
    }

}
