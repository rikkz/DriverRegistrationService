package com.intuit.DriverRegistrationService.model.response;

import lombok.Builder;
import lombok.Getter;


/**
 * Data transfer object (DTO) class representing a response for driver registration status.
 * This class is designed for use in API responses, providing information about whether a driver is
 * registered or not.
 */
@Builder
@Getter
public class IsDriverRegisteredResponse {

    /**
     * Indicates whether the driver is registered or not.
     * If true, it means the driver is registered; if false, the driver is not registered.
     */
    private final Boolean isDriverRegistered;

    /**
     * Indicates whether the driver is registered or not.
     * If true, it means the driver is registered; if false, the driver is not registered.
     */
    private GetDriverInformationResponse driverInformation;

}
