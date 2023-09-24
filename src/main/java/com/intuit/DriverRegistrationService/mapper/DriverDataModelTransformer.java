package com.intuit.DriverRegistrationService.mapper;

import com.intuit.DriverRegistrationService.model.entities.address.Address;
import com.intuit.DriverRegistrationService.model.entities.address.AddressBook;
import com.intuit.DriverRegistrationService.model.entities.dbModel.DriverDataModel;
import com.intuit.DriverRegistrationService.model.entities.driver.Contact;
import com.intuit.DriverRegistrationService.model.entities.driver.DriverStatus;
import com.intuit.DriverRegistrationService.model.entities.driver.Gender;
import com.intuit.DriverRegistrationService.model.entities.driver.Person;
import com.intuit.DriverRegistrationService.model.request.RegisterDriverRequest;
import com.intuit.DriverRegistrationService.model.response.GetDriverInformationResponse;
import com.intuit.DriverRegistrationService.model.response.IsDriverRegisteredResponse;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.UUID;

@Slf4j
@Component
public class DriverDataModelTransformer {

    public DriverDataModel transformRegisterDriverRequest(final RegisterDriverRequest registerDriverRequest) {
        String newDriverId = UUID.randomUUID().toString();
        log.info("Here is the newDriverId :" + newDriverId);
        AddressBook addressBook = AddressBook.builder()
                .currentAddress(transformAddress(registerDriverRequest.getCurrentAddress()))
                .permanentAddress(transformAddress(registerDriverRequest.getPermanentAddress()))
                .build();
        String location = getLocation(registerDriverRequest.getCurrentAddress());

        Person person = Person.builder()
                .firstName(registerDriverRequest.getName().getFirstName())
                .middleName(registerDriverRequest.getName().getMiddleName())
                .lastName(registerDriverRequest.getName().getLastName())
                .dateOfBirth(registerDriverRequest.getDob())
                .gender(Gender.valueOf(registerDriverRequest.getGender().toString()))
                .build();



        return DriverDataModel.builder()
                .driverId(newDriverId)
                .driverStatus(DriverStatus.REGISTRATION_PENDING)
                .emailId(registerDriverRequest.getEmailId())
                .mobileNumber(registerDriverRequest.getCountryCode() + "-" + registerDriverRequest.getPhoneNumber())
                .driverLocation(location)
                .driverAddressBook(addressBook)
                .driverPersonalInformation(person)
                .build();
    }

    public ResponseEntity<IsDriverRegisteredResponse> buildIsDriverRegisteredResponse(
            List<DriverDataModel> driverDataModelList) {

        if (CollectionUtils.isEmpty(driverDataModelList)) {
            log.info("Didn't found the Record in the database");
            return ResponseEntity.ok(IsDriverRegisteredResponse.builder()
                    .isDriverRegistered(false)
                    .build());
        }

        log.info("Found the Record in the database...");

        return ResponseEntity.ok(IsDriverRegisteredResponse.builder()
                .isDriverRegistered(true)
                .driverId(driverDataModelList.get(0).getDriverId())
                .build());
    }

    /**
     * Transforming the DriverDataModel to getDriverInformationResponse
     * @param driverDataMode
     * @return
     */
    public ResponseEntity<GetDriverInformationResponse> buildGetDriverInformationResponse(
            @NonNull DriverDataModel driverDataMode) {

        GetDriverInformationResponse getDriverInformationResponse =
                GetDriverInformationResponse.builder()
                        .driverId(driverDataMode.getDriverId())
                        .addressBook(driverDataMode.getDriverAddressBook())
                        .driverStatus(driverDataMode.getDriverStatus().toString())
                        .contact(Contact.builder()
                                .emailId(driverDataMode.getEmailId())
                                .mobileNumber(driverDataMode.getMobileNumber())
                                .build())
                        .person(Person.builder()
                                .gender(driverDataMode.getDriverPersonalInformation().getGender())
                                .lastName(driverDataMode.getDriverPersonalInformation().getLastName())
                                .middleName(driverDataMode.getDriverPersonalInformation().getMiddleName())
                                .firstName(driverDataMode.getDriverPersonalInformation().getFirstName())
                                .dateOfBirth(driverDataMode.getDriverPersonalInformation().getDateOfBirth())
                                .build())
                        .build();
        return ResponseEntity.ok(getDriverInformationResponse);
    }

    public DriverDataModel createDataDriverModelWithUpdatedStatus(final DriverDataModel requestedDataDriverModel,
                                                                  final String updatedStatus) {
       return DriverDataModel.builder()
                .mobileNumber(requestedDataDriverModel.getMobileNumber())
                .driverStatus(DriverStatus.valueOf(updatedStatus))
                .driverLocation(requestedDataDriverModel.getDriverLocation())
                .driverAddressBook(requestedDataDriverModel.getDriverAddressBook())
                .driverPersonalInformation(requestedDataDriverModel.getDriverPersonalInformation())
                .emailId(requestedDataDriverModel.getEmailId())
                .driverId(requestedDataDriverModel.getDriverId())
                .build();
    }

    private Address transformAddress(com.intuit.DriverRegistrationService.model.request.common.Address address) {
        return Address.builder()
                .addressLine1(address.getAddressLine1())
                .addressLine2(address.getAddressLine2())
                .addressLine3(address.getAddressLine3())
                .country(address.getCountry())
                .city(address.getCity())
                .state(address.getState())
                .zipCode(address.getZipCode())
                .build();
    }

    private String getLocation(com.intuit.DriverRegistrationService.model.request.common.Address address) {
        return address.getCountry() + ":" + address.getState() + ":" + address.getCity();
    }
}
