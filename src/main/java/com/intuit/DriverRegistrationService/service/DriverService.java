package com.intuit.DriverRegistrationService.service;


import com.intuit.DriverRegistrationService.model.entities.dbModel.DriverDataModel;
import com.intuit.DriverRegistrationService.model.request.RegisterDriverRequest;
import com.intuit.DriverRegistrationService.model.request.UpdateDriverDetailsRequest;
import com.intuit.DriverRegistrationService.model.request.UpdateDriverStatusRequest;
import com.intuit.DriverRegistrationService.model.response.GetDriverInformationResponse;
import com.intuit.DriverRegistrationService.model.response.IsDriverRegisteredResponse;
import com.intuit.DriverRegistrationService.repository.DriverRepository;
import com.intuit.DriverRegistrationService.validations.DriverControllerValidator;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class DriverService {

    /**
     * Validator for validating driver registration requests.
     */
    @Autowired
    private DriverControllerValidator driverControllerValidator;

    @Autowired
    private DriverRepository driverRepository;


    public ResponseEntity<IsDriverRegisteredResponse> isDriverRegistered(
            @NonNull final String requestedCountryCode,
            @NonNull final String requestedMobileNumber) {
        driverControllerValidator.validateMobileNumber(requestedCountryCode, requestedMobileNumber);

        return ResponseEntity.ok(IsDriverRegisteredResponse.builder()
                .isDriverRegistered(true)
                .build());
    }


    public ResponseEntity<GetDriverInformationResponse> getDriverInformation(
            @NonNull final String driverId) {
        driverControllerValidator.isValidDriverId(driverId);

        return ResponseEntity.ok(GetDriverInformationResponse.builder()
                .build());
    }

    public void updateDriverStatus(@NonNull final UpdateDriverStatusRequest updateDriverStatusRequest) {
        driverControllerValidator.isValidDriverId(updateDriverStatusRequest.getDriverId());

    }

    public void registerDriver(@NonNull final RegisterDriverRequest registerDriverRequest) {
        driverControllerValidator.validateMobileNumber(registerDriverRequest.getCountryCode(),
                registerDriverRequest.getPhoneNumber());
        driverControllerValidator.validateEmail(registerDriverRequest.getEmailId());
        driverControllerValidator.validateAge(registerDriverRequest.getDob());
    }

    public void updateDriverDetails(@NonNull final UpdateDriverDetailsRequest updateDriverDetailsRequest) {
        driverControllerValidator.validateMobileNumber(updateDriverDetailsRequest.getCountryCode(),
                updateDriverDetailsRequest.getPhoneNumber());
        driverControllerValidator.validateEmail(updateDriverDetailsRequest.getEmailId());
        driverControllerValidator.validateAge(updateDriverDetailsRequest.getDob());
        driverControllerValidator.isValidDriverId(updateDriverDetailsRequest.getDriverId());
    }


}
