package com.intuit.DriverRegistrationService.service;


import com.intuit.DriverRegistrationService.mapper.DriverDataModelTransformer;
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
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service Layer for the DriverService to maintain the APIs for the same.
 */
@Slf4j
@Service
public class DriverService {

    /**
     * Validator for validating driver registration requests.
     */
    @Autowired
    private DriverControllerValidator driverControllerValidator;

    /**
     * Driver Repository to maintain the Crud operations on the DB layer.
     */
    @Autowired
    private DriverRepository driverRepository;

    /**
     * Transformer Layer to transform into DTO objects for the repository layer.
     */
    @Autowired
    private DriverDataModelTransformer driverDataModelTransformer;

    /**
     * Service operation for the isDriverRegistered.
     */
    @Cacheable(value = "DriverCache", key = "{#requestedCountryCode , #requestedMobileNumber}")
    public ResponseEntity<IsDriverRegisteredResponse> isDriverRegistered(
            @NonNull final String requestedCountryCode,
            @NonNull final String requestedMobileNumber) {

        log.info("Reached the Service Layer for isDriverRegistered");
        //validations
        driverControllerValidator.validateMobileNumber(requestedCountryCode, requestedMobileNumber);

       //calling the repository to fetch details
        List<DriverDataModel> driverDataModelList =
                    driverRepository.findByMobileNumber(requestedCountryCode + "-" + requestedMobileNumber);

        //returning the response
        return driverDataModelTransformer.buildIsDriverRegisteredResponse(driverDataModelList);
    }


    /**
     * Service operation to fetch the driver details
     */
    @Cacheable(value = "DriverCache", key = "#driverId")
    public ResponseEntity<GetDriverInformationResponse> getDriverInformation(
            @NonNull final String driverId) {

        log.info("Reached the Service Layer for getDriverInformation");
        //validations
        driverControllerValidator.isValidDriverId(driverId);

        //calling the repository to fetch details
        Optional<DriverDataModel> driverDataModelOptional =
                driverRepository.findById(driverId);

        //Validating if the record exists
        driverControllerValidator.doesDriverExist(driverDataModelOptional, driverId);

        //transforming into the Appropriate Response model
        return driverDataModelTransformer.buildGetDriverInformationResponse(driverDataModelOptional.get());
    }

    /**
     * Service operation to register a update the  driver status.
     */
    @CacheEvict(value = "DriverCache" , key = "#updateDriverStatusRequest.driverId")
    public void updateDriverStatus(@NonNull final UpdateDriverStatusRequest updateDriverStatusRequest) {
        driverControllerValidator.isValidDriverId(updateDriverStatusRequest.getDriverId());

        //calling the repository to fetch details
        Optional<DriverDataModel> driverDataModelOptional =
                driverRepository.findById(updateDriverStatusRequest.getDriverId());

        //Validating if the record exists
        driverControllerValidator.doesDriverExist(driverDataModelOptional, updateDriverStatusRequest.getDriverId());

        //transformerLayer to create the clone of the driver data Model
        DriverDataModel updatedDriverDetailModel =
                driverDataModelTransformer.createDataDriverModelWithUpdatedStatus(driverDataModelOptional.get(),
                updateDriverStatusRequest.getStatus().toString());

        //save the new Data
        driverRepository.save(updatedDriverDetailModel);
    }

    /**
     * Service operation to register a new driver details
     */
    @CacheEvict(value = "DriverCache" ,  key = "{#registerDriverRequest.getCountryCode() , #registerDriverRequest.getPhoneNumber()}")
    public ResponseEntity<String> registerDriver(@NonNull final RegisterDriverRequest registerDriverRequest) {

        log.info("Reached the Service Layer for registerDriver");
        //validations
        driverControllerValidator.validateMobileNumber(registerDriverRequest.getCountryCode(),
                registerDriverRequest.getPhoneNumber());
        driverControllerValidator.validateEmail(registerDriverRequest.getEmailId());
        driverControllerValidator.validateAge(registerDriverRequest.getDob());
        driverControllerValidator.validateAddress(registerDriverRequest.getPermanentAddress());
        driverControllerValidator.validateAddress(registerDriverRequest.getCurrentAddress());
        driverControllerValidator.validateName(registerDriverRequest.getName());

        //transforming the Data
        DriverDataModel driverDataModel =
                driverDataModelTransformer.transformRegisterDriverRequest(registerDriverRequest);

        //calling the repository to fetch details
        List<DriverDataModel> driverDataModelList =
                driverRepository.findByMobileNumber(
                        registerDriverRequest.getCountryCode() + "-" + registerDriverRequest.getPhoneNumber());

        //validate if the record Already exist or not.
        driverControllerValidator.driverShouldNotExist(driverDataModelList);

        //Saving the data to the database
        driverRepository.save(driverDataModel);

        return ResponseEntity.ok(driverDataModel.getDriverId());
    }

    /**
     * Update the Personal Information for the Driver.
     * @param updateDriverDetailsRequest
     */
    public void updateDriverDetails(@NonNull final UpdateDriverDetailsRequest updateDriverDetailsRequest) {
        log.info("Reached the Service Layer for updateDriverDetails");
        //TODO  : Complete the API
        log.warn("This API is currently work in progress");
    }


}
