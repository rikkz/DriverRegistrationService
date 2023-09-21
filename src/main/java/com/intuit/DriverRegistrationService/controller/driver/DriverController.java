package com.intuit.DriverRegistrationService.controller.driver;


import com.intuit.DriverRegistrationService.exceptions.model.BadRequestException;
import com.intuit.DriverRegistrationService.model.request.RegisterDriverRequest;
import com.intuit.DriverRegistrationService.model.request.UpdateDriverDetailsRequest;
import com.intuit.DriverRegistrationService.model.request.UpdateDriverStatusRequest;
import com.intuit.DriverRegistrationService.model.response.GetDriverInformationResponse;
import com.intuit.DriverRegistrationService.model.response.IsDriverRegisteredResponse;
import com.intuit.DriverRegistrationService.service.DriverService;
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

    @Autowired
    private DriverService driverService;

    /**
     * Handles a POST request to check if a driver is registered.
     *
     * @param requestedCountryCode, requestedMobileNumber The request body containing driver information.
     * @return A ResponseEntity containing the response indicating whether the driver is registered.
     * @throws BadRequestException If the request is invalid, such as an invalid country code or mobile number.
     */
    @GetMapping("/isDriverRegistered")
    public ResponseEntity<IsDriverRegisteredResponse> isDriverRegistered (
            @RequestParam @NonNull final String requestedCountryCode ,
            @RequestParam @NonNull final String  requestedMobileNumber) {

        log.info("Starting the isDriverRegistered Journey");
        return driverService.isDriverRegistered(requestedCountryCode, requestedMobileNumber);
    }

    /**
     * Handles a POST request to register a new driver.
     *
     * @param registerDriverRequest The request body containing driver registration information.
     */
    @PostMapping("/registerDriver")
    public ResponseEntity<String> registerDriver (
            @NonNull @RequestBody final RegisterDriverRequest registerDriverRequest) {
        log.info("Starting the registerDriver Journey");
        return driverService.registerDriver(registerDriverRequest);
    }

    /**
     * Handles a POST request to register a new driver.
     *
     * @param updateDriverDetailsRequest The request body containing updated driver registration information.
     */
    @PutMapping("/updateDriverDetails")
    public void updateDriverDetails (
            @NonNull @RequestBody final UpdateDriverDetailsRequest updateDriverDetailsRequest) {
        log.info("Starting the updateDriverDetails Journey");
        driverService.updateDriverDetails(updateDriverDetailsRequest);
    }

    /**
     * Handles a POST request to update the status of a driver.
     * @param updateDriverStatusRequest The request body containing the updated driver status.
     */
    @PostMapping("/updateDriverStatus")
    public void updateDriverStatus (
            @NonNull @RequestBody final UpdateDriverStatusRequest updateDriverStatusRequest) {
        log.info("Starting the updateDriverStatus Journey");
        driverService.updateDriverStatus(updateDriverStatusRequest);
    }

    /**
     * Handles a GET request to retrieve driver information.
     *
     * @param driverId The request body containing the driver's Id.
     */
    @GetMapping("/getDriverInformation")
    public ResponseEntity<GetDriverInformationResponse> getDriverInformation (
            @NonNull @RequestParam final String driverId) {
        log.info("Starting the getDriverInformation Journey");
        return driverService.getDriverInformation(driverId);
    }
}
