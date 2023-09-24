package com.intuit.DriverRegistrationService.Controller;

import com.intuit.DriverRegistrationService.controller.driver.DriverController;
import com.intuit.DriverRegistrationService.model.request.RegisterDriverRequest;
import com.intuit.DriverRegistrationService.model.request.UpdateDriverStatusRequest;
import com.intuit.DriverRegistrationService.model.request.common.Address;
import com.intuit.DriverRegistrationService.model.request.common.Gender;
import com.intuit.DriverRegistrationService.model.request.common.Name;
import com.intuit.DriverRegistrationService.model.response.GetDriverInformationResponse;
import com.intuit.DriverRegistrationService.model.response.IsDriverRegisteredResponse;
import com.intuit.DriverRegistrationService.model.response.RegisterDriverResponse;
import com.intuit.DriverRegistrationService.service.DriverService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class DriverControllerTest {

    @Mock
    private DriverService driverService;

    @InjectMocks
    private DriverController driverController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize annotated mocks
    }

    @Test
    void testIsDriverRegistered() {
        // Create a sample request
        String countryCode = "US";
        String mobileNumber = "1234567890";

        // Create a sample response
        IsDriverRegisteredResponse response = IsDriverRegisteredResponse
                .builder()
                .isDriverRegistered(true)
                .build();

        // Mock the behavior of the driverService.isDriverRegistered method
        when(driverService.isDriverRegistered(countryCode, mobileNumber)).thenReturn(ResponseEntity.ok(response));

        // Call the controller method
        ResponseEntity<IsDriverRegisteredResponse> result = driverController.isDriverRegistered(countryCode,
                mobileNumber);

        // Verify that the service method was called with the correct arguments
        verify(driverService, times(1)).isDriverRegistered(countryCode, mobileNumber);

        // Assert the result
        assertNotNull(result);
        assertEquals(response, result.getBody());
    }

    @Test
    void testRegisterDriver() {
        // Create a sample request

        ResponseEntity<RegisterDriverResponse> registerDriverResponseMock = mock(ResponseEntity.class);

        Address sampleAddress = Address.builder()
                .addressLine1("1st Street")
                .addressLine2("2nd Lane")
                .addressLine3("House no. 64")
                .state("Arizona")
                .city("Sonipat")
                .zipCode("111-111")
                .country("USA")
                .build();

        LocalDate date = LocalDate.of(2000, 12, 12);

        RegisterDriverRequest request = RegisterDriverRequest.builder()
                .countryCode("+91")
                .dob(date)
                .emailId("mangla.rohit")
                .gender(Gender.MALE)
                .name(Name.builder()
                        .firstName("Rohit")
                        .lastName("Rakesh")
                        .middleName("Mangla")
                        .build())
                .permanentAddress(sampleAddress)
                .currentAddress(sampleAddress)
                .phoneNumber("7988164534")
                .build();

        when(driverService.registerDriver(request)).thenReturn(registerDriverResponseMock);

        // Call the controller method
        ResponseEntity<RegisterDriverResponse> response = driverController.registerDriver(request);

        // Verify that the service method was called with the correct argument
        verify(driverService, times(1)).registerDriver(request);
        assertEquals(registerDriverResponseMock , response);
    }

    @Test
    void testUpdateDriverStatus() {
        // Create a sample request
        UpdateDriverStatusRequest request = UpdateDriverStatusRequest.builder().driverId("Hello")
                .status(UpdateDriverStatusRequest.Status.ACTIVE)
                .build();

        // Call the controller method
        driverController.updateDriverStatus(request);

        // Verify that the service method was called with the correct argument
        verify(driverService, times(1)).updateDriverStatus(request);
    }

    @Test
    void testGetDriverInformation() {
        // Create a sample driver ID
        String driverId = "12345";

        // Create a sample response
        GetDriverInformationResponse response = GetDriverInformationResponse.builder().build();

        // Mock the behavior of the driverService.getDriverInformation method
        when(driverService.getDriverInformation(driverId)).thenReturn(ResponseEntity.ok(response));

        // Call the controller method
        ResponseEntity<GetDriverInformationResponse> result = driverController.getDriverInformation(driverId);

        // Verify that the service method was called with the correct argument
        verify(driverService, times(1)).getDriverInformation(driverId);

        // Assert the result
        assertNotNull(result);
        assertEquals(response, result.getBody());
    }
}
