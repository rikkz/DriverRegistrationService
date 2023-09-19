package com.intuit.DriverRegistrationService.model.request;

import lombok.Builder;
import lombok.Getter;

/**
 * Represents a request to retrieve driver information.
 */
@Getter
@Builder
public class GetDriverInformationRequest {
    /**
     * The unique identifier of the driver.
     */
    private String driverId;

    /**
     * Constructs a new request with the specified driver identifier.
     *
     * @param driverId The unique identifier of the driver.
     */
    public GetDriverInformationRequest(String driverId) {
        this.driverId = driverId;
    }
}

