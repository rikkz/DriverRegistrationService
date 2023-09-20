package com.intuit.DriverRegistrationService.controller.driver;


import com.intuit.DriverRegistrationService.exceptions.model.BadRequestException;
import com.intuit.DriverRegistrationService.model.request.GetDriverInformationRequest;
import com.intuit.DriverRegistrationService.model.request.RegisterDriverRequest;
import com.intuit.DriverRegistrationService.model.request.UpdateDriverStatusRequest;
import com.intuit.DriverRegistrationService.model.response.IsDriverRegisteredResponse;
import com.intuit.DriverRegistrationService.validations.DriverControllerValidator;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller class for handling driver-related operations in the Driver Registration Service API.
 * This class defines endpoints for checking driver registration status and includes request validation.
 */
@RestController
@RequestMapping("/api/drivers")
@Slf4j
public class DriverController {

    /**
     * Validator for validating driver registration requests.
     */
    @Autowired
    private DriverControllerValidator driverControllerValidator;

    /**
     * Handles a POST request to check if a driver is registered.
     *
     * @param isDriverRegisteredRequest The request body containing driver information.
     * @return A ResponseEntity containing the response indicating whether the driver is registered.
     * @throws BadRequestException If the request is invalid, such as an invalid country code or mobile number.
     */
    @GetMapping("/isDriverRegistered")
    public ResponseEntity<IsDriverRegisteredResponse> isDriverRegistered (
            @RequestParam @NonNull final String requestedCountryCode ,
            @RequestParam @NonNull final String  requestedMobileNumber) {

        log.info("Starting the isDriverRegistered Journey");
        driverControllerValidator.validateIsUserRegisteredRequest(requestedCountryCode, requestedMobileNumber);

        // If validation passes, return a successful response
        return ResponseEntity.ok(IsDriverRegisteredResponse.builder()
                .isDriverRegistered(true)
                .build());
    }

    /**
     * Handles a POST request to register a new driver.
     *
     * @param registerDriverRequest The request body containing driver registration information.
     */
    @PostMapping("/registerDriver")
    public void registerDriver (
            @RequestBody final RegisterDriverRequest registerDriverRequest) {
        log.info("Starting the registerDriver Journey");
    }

    /**
     * Handles a POST request to update the status of a driver.
     *
     * @param updateDriverStatusRequest The request body containing the updated driver status.
     */
    @PostMapping("/updateDriverStatus")
    public void updateDriverStatus (
            @RequestBody final UpdateDriverStatusRequest updateDriverStatusRequest) {
        log.info("Starting the updateDriverStatus Journey");
    }

    /**
     * Handles a GET request to retrieve driver information.
     *
     * @param getDriverInformationRequest The request body containing the driver's information request.
     */
    @GetMapping("/getDriverInformation")
    public void getDriverInformation (
            @RequestBody final GetDriverInformationRequest getDriverInformationRequest) {
        log.info("Starting the getDriverInformation Journey");
    }
}
