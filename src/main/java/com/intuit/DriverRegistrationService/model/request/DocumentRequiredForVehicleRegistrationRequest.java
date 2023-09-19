package com.intuit.DriverRegistrationService.model.request;

import lombok.Builder;
import lombok.Getter;

/**
 * Represents a request to obtain a list of required documents for the registration of a specific vehicle.
 */
@Getter
@Builder
public class DocumentRequiredForVehicleRegistrationRequest {
    /**
     * The driver's unique identifier.
     */
    private String driverId;

    /**
     * The vehicle's unique identifier.
     */
    private String vehicleId;
}

