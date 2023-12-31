package com.intuit.DriverRegistrationService.controller.vehicle;

import com.intuit.DriverRegistrationService.model.request.GetVehicleDetailsRequest;
import com.intuit.DriverRegistrationService.model.request.RegisterVehicleRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for handling vehicle-related operations in the Driver Registration Service API.
 * This class defines endpoints for registering vehicles and get its respective details.
 */
@RestController
@RequestMapping("/api/vehicles")
@Slf4j
public class VehicleController {

    /**
     * Handles a POST request to register a new vehicle against a driver.
     *
     * @param registerVehicleRequest The request body containing vehicle registration information.
     */
    @PostMapping("/registerVehicle")
    public void registerVehicle (
            @RequestBody final RegisterVehicleRequest registerVehicleRequest) {
        log.info("Starting the registerVehicle Journey");
        //TODO : Complete the implementation for the Rest API
    }

    /**
     * Handles a POST request to get the  vehicle information against a driver.
     *
     * @param getVehicleDetailsRequest The request body containing vehicle details information.
     */
    @PostMapping("/getVehicleDetails")
    public void getVehicleDetails (
            @RequestBody final GetVehicleDetailsRequest getVehicleDetailsRequest) {
        log.info("Starting the getVehicleDetails Journey");
        //TODO : Complete the implementation for the Rest API
    }

}
