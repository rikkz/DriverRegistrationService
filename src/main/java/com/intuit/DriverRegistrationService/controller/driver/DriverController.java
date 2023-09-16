package com.intuit.DriverRegistrationService.controller.driver;


import com.intuit.DriverRegistrationService.controller.BaseController;
import com.intuit.DriverRegistrationService.exceptions.model.BadRequestException;
import com.intuit.DriverRegistrationService.model.request.IsDriverRegisteredRequest;
import com.intuit.DriverRegistrationService.model.response.IsDriverRegisteredResponse;
import com.intuit.DriverRegistrationService.validations.DriverControllerValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/drivers")
public class DriverController extends BaseController {

    @Autowired
    private DriverControllerValidator driverControllerValidator;
    @PostMapping("/isDriverRegistered")
    public ResponseEntity<IsDriverRegisteredResponse> isDriverRegistered (
            @RequestBody final IsDriverRegisteredRequest isDriverRegisteredRequest) throws BadRequestException {

        logger.info("Here is the Mobile number : "  + isDriverRegisteredRequest.toString());

        try {
            driverControllerValidator.validateIsUserRegisteredRequest(isDriverRegisteredRequest);
        } catch (BadRequestException badRequestException) {
            throw badRequestException;
        }
        return ResponseEntity.ok(IsDriverRegisteredResponse.builder()
                .isDriverRegistered(true)
                .build());
    }
}
