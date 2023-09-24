package com.intuit.DriverRegistrationService.model.response;


import lombok.Builder;
import lombok.Getter;

/**
 * Data transfer object (DTO) class representing a response for registering the driver .
 * If the Driver is successfully registered , Returning the driver response details tp save additional query.
 */
@Builder
@Getter
public class RegisterDriverResponse {

    /**
     * Driver Information that is currently saved in the database.
     */
    private GetDriverInformationResponse driverInformation;
}
