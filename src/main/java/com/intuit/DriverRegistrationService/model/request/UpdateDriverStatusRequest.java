package com.intuit.DriverRegistrationService.model.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

/**
 * Represents a request to update the status of a driver.
 */
@Getter
@Builder
public class UpdateDriverStatusRequest {
    /**
     * The driver's unique identifier.
     */
    @NonNull
    private final String driverId;

    /**
     * The updated status of the driver, which can be ACTIVE or NOT_ACTIVE.
     */
    @NonNull
    private final Status status;

    /**
     * Enum representing the driver's status.
     */
    public enum Status {
        ACTIVE, NOT_ACTIVE, SUSPENDED, TERMINATED, REGISTRATION_PENDING, VERIFICATION_PENDING
    }
}

