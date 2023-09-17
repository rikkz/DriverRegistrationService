package com.intuit.DriverRegistrationService.config;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;


public class CountryDigitsMapConfigTest {

    private CountryDigitsMapConfig countryDigitsMapConfig;
    private Map<String , Integer> map;

    @BeforeEach
    public void setup() {
        countryDigitsMapConfig = new CountryDigitsMapConfig();
        map = countryDigitsMapConfig.countryToDigitsMap();
    }
    @Test
    public void test() {
        Assertions.assertTrue(map.containsKey("+91"));
    }
}
