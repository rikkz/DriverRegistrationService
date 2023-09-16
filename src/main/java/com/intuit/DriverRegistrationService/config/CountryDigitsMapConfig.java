package com.intuit.DriverRegistrationService.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CountryDigitsMapConfig {

    @Bean
    public Map<String, Integer> countryToDigitsMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("+91", 10); // India
        map.put("+44", 11); // UK
        // Add more countries as needed
        return map;
    }

}
