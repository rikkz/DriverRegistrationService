package com.intuit.DriverRegistrationService.model.request;

import lombok.Builder;
import lombok.Getter;

/**
 * Represents a request to retrieve vehicle details.
 */
@Getter
@Builder
public class GetVehicleDetailsRequest {
    /**
     * The unique identifier of the vehicle.
     */
    private String vehicleId;
}

