package com.intuit.DriverRegistrationService.model.request;

import lombok.Builder;
import lombok.Getter;

/**
 * Represents a request to update the status of a driver.
 */
@Getter
@Builder
public class UpdateDriverStatusRequest {
    /**
     * The driver's unique identifier.
     */
    private final String driverId;

    /**
     * The updated status of the driver, which can be ACTIVE or NOT_ACTIVE.
     */
    private final Status status;

    /**
     * Enum representing the driver's status.
     */
    public enum Status {
        ACTIVE, NOT_ACTIVE
    }
}

