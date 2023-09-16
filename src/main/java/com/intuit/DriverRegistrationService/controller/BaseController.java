package com.intuit.DriverRegistrationService.controller;

import com.intuit.DriverRegistrationService.controller.driver.DriverController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Base class for controllers in the Driver Registration Service application.
 * It provides a shared logger for logging controller-related information.
 */
public class BaseController {

    /**
     * The shared logger instance used for logging controller-related information.
     */
    public static final Logger logger = LogManager.getLogger(DriverController.class);
}
