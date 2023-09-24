package com.intuit.DriverRegistrationService.integrationTesting.service;

import com.intuit.DriverRegistrationService.exceptions.model.BadRequestException;
import com.intuit.DriverRegistrationService.model.response.IsDriverRegisteredResponse;
import com.intuit.DriverRegistrationService.service.DriverService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class DriverServiceIntegrationTesting {

    @Autowired
    private DriverService driverService;

    @Test
    public void successDriverIsRegistered() {
        ResponseEntity<IsDriverRegisteredResponse> response =
                driverService.isDriverRegistered("+91" , "9999999999");

        Assertions.assertTrue(response.getStatusCode().is2xxSuccessful());
        Assertions.assertTrue(response.getBody().getIsDriverRegistered());

    }

    @Test
    public void successDriverIsNotRegistered() {
        ResponseEntity<IsDriverRegisteredResponse> response =
                driverService.isDriverRegistered("+91" , "9239999999");

        Assertions.assertTrue(response.getStatusCode().is2xxSuccessful());
        Assertions.assertFalse(response.getBody().getIsDriverRegistered());
    }

    @Test
    public void failureInvalidCountryCode() {
        Assertions.assertThrows(BadRequestException.class,
                () ->driverService.isDriverRegistered("+9w1", "9239999999"));
    }

    @Test
    public void failureInvalidMobileNumber() {
        Assertions.assertThrows(BadRequestException.class,
                () ->driverService.isDriverRegistered("+91", "wed"));
    }

    @Test
    public void successGetDriverInformation() {
        Assertions.assertTrue(driverService.getDriverInformation("5fdccb98-97cf-44a4-8179-5104ba955749")
                .getStatusCode().is2xxSuccessful());
    }


}
