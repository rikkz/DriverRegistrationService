package com.intuit.DriverRegistrationService.mapper;

import com.intuit.DriverRegistrationService.model.entities.address.Address;
import com.intuit.DriverRegistrationService.model.entities.address.AddressBook;
import com.intuit.DriverRegistrationService.model.entities.dbModel.DriverDataModel;
import com.intuit.DriverRegistrationService.model.entities.driver.DriverStatus;
import com.intuit.DriverRegistrationService.model.entities.driver.Person;
import com.intuit.DriverRegistrationService.model.request.RegisterDriverRequest;
import com.intuit.DriverRegistrationService.model.request.common.Gender;
import com.intuit.DriverRegistrationService.model.request.common.Name;
import com.intuit.DriverRegistrationService.model.response.GetDriverInformationResponse;
import com.intuit.DriverRegistrationService.model.response.IsDriverRegisteredResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DriverDataModelTransformerTest {

    private DriverDataModelTransformer transformer;

    @BeforeEach
    void setUp() {
        transformer = new DriverDataModelTransformer();
    }

    @Test
    void testTransformRegisterDriverRequest() {
        RegisterDriverRequest request = createSampleRegisterDriverRequest();
        DriverDataModel result = transformer.transformRegisterDriverRequest(request);

        assertNotNull(result);
        assertEquals(DriverStatus.REGISTRATION_PENDING, result.getDriverStatus());
        // Add more assertions as needed
    }

    @Test
    void testBuildIsDriverRegisteredResponse_NotFound() {
        List<DriverDataModel> driverDataModelList = Collections.emptyList();
        ResponseEntity<IsDriverRegisteredResponse> responseEntity = transformer.buildIsDriverRegisteredResponse(driverDataModelList);

        assertNotNull(responseEntity);
        assertEquals(200, responseEntity.getStatusCodeValue());
        IsDriverRegisteredResponse response = responseEntity.getBody();
        assertNotNull(response);
        assertFalse(response.getIsDriverRegistered());
    }

    @Test
    void testBuildIsDriverRegisteredResponse_Found() {
        List<DriverDataModel> driverDataModelList = Collections.singletonList(createSampleDriverDataModel());
        ResponseEntity<IsDriverRegisteredResponse> responseEntity = transformer.buildIsDriverRegisteredResponse(driverDataModelList);

        assertNotNull(responseEntity);
        assertEquals(200, responseEntity.getStatusCodeValue());
        IsDriverRegisteredResponse response = responseEntity.getBody();
        assertNotNull(response);
        assertTrue(response.getIsDriverRegistered().booleanValue());
        // Add more assertions as needed
    }

    @Test
    void testBuildGetDriverInformationResponse() {
        DriverDataModel driverDataModel = createSampleDriverDataModel();
        ResponseEntity<GetDriverInformationResponse> responseEntity = transformer.buildGetDriverInformationResponse(driverDataModel);

        assertNotNull(responseEntity);
        assertEquals(200, responseEntity.getStatusCodeValue());
        GetDriverInformationResponse response = responseEntity.getBody();
        assertNotNull(response);
    }

    @Test
    void testCreateDataDriverModelWithUpdatedStatus() {
        DriverDataModel requestedDataDriverModel = createSampleDriverDataModel();
        String updatedStatus = "ACTIVE";
        DriverDataModel result = transformer.createDataDriverModelWithUpdatedStatus(requestedDataDriverModel, updatedStatus);

        assertNotNull(result);
        assertEquals(DriverStatus.ACTIVE, result.getDriverStatus());

    }

    // Helper method to create a sample RegisterDriverRequest
    private RegisterDriverRequest createSampleRegisterDriverRequest() {
        return RegisterDriverRequest.builder()
                .name(Name.builder()
                        .firstName("John")
                        .middleName("Doe")
                        .lastName("Smith")
                        .build())
                .dob(LocalDate.of(2000, 12,12))
                .gender(Gender.MALE)
                .countryCode("+1")
                .emailId("johndoe@example.com")
                .phoneNumber("1234567890")
                .currentAddress(com.intuit.DriverRegistrationService.model.request.common.Address.builder()
                        .addressLine1("123 Main St")
                        .city("New York")
                        .state("NY")
                        .zipCode("10001")
                        .country("USA")
                        .build())
                .permanentAddress(com.intuit.DriverRegistrationService.model.request.common.Address.builder()
                        .addressLine1("456 Elm St")
                        .city("Los Angeles")
                        .state("CA")
                        .zipCode("90001")
                        .country("USA")
                        .build())
                .build();
    }



    private DriverDataModel createSampleDriverDataModel() {
        return DriverDataModel.builder()
                .driverId("1234567890") // Replace with a unique driver ID
                .driverStatus(DriverStatus.ACTIVE) // Replace with the desired status
                .emailId("driver@example.com")
                .countryCode("+1")
                .mobileNumber("1234567890")
                .driverAddressBook(createSampleAddressBook())
                .driverPersonalInformation(createSamplePerson())
                .driverLocation("USA:NY:New York") // Replace with the desired location
                .build();
    }

    private AddressBook createSampleAddressBook() {
        // Create and return a sample AddressBook object
        return AddressBook.builder()
                .currentAddress(createSampleAddress("123 Main St", "New York", "NY", "10001", "USA"))
                .permanentAddress(createSampleAddress("456 Elm St", "Los Angeles", "CA", "90001", "USA"))
                .build();
    }

    private Address createSampleAddress(String addressLine1, String city, String state, String zipCode, String country) {
        return Address.builder()
                .addressLine1(addressLine1)
                .city(city)
                .state(state)
                .zipCode(zipCode)
                .country(country)
                .build();
    }

    private Person createSamplePerson() {
        // Create and return a sample Person object
        return Person.builder()
                .firstName("John")
                .middleName("Doe")
                .lastName("Smith")
                .dateOfBirth(LocalDate.of(2000, 12,12)) // Replace with the desired date of birth
                .gender(com.intuit.DriverRegistrationService.model.entities.driver.Gender.MALE) // Replace with the desired gender
                .build();
    }

}
