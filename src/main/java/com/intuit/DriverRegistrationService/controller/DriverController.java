package com.intuit.DriverRegistrationService.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/drivers")
public class DriverController {

    private static final Logger logger = LogManager.getLogger(DriverController.class);
    @GetMapping("/{mobileNumber}")
    public ResponseEntity<Boolean> isDriverRegistered(@PathVariable final String mobileNumber) {

        logger.info("Here is the Mobile number : "  + mobileNumber);
        return ResponseEntity.ok(true);
    }
}
