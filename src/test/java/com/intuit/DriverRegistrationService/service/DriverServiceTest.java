package com.intuit.DriverRegistrationService.service;

import com.intuit.DriverRegistrationService.mapper.DriverDataModelTransformer;
import com.intuit.DriverRegistrationService.model.entities.dbModel.DriverDataModel;
import com.intuit.DriverRegistrationService.model.request.RegisterDriverRequest;
import com.intuit.DriverRegistrationService.model.request.UpdateDriverStatusRequest;
import com.intuit.DriverRegistrationService.model.response.GetDriverInformationResponse;
import com.intuit.DriverRegistrationService.model.response.IsDriverRegisteredResponse;
import com.intuit.DriverRegistrationService.repository.DriverRepository;
import com.intuit.DriverRegistrationService.validations.DriverControllerValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

class DriverServiceTest {

    @Mock
    private DriverControllerValidator driverControllerValidator;

    @Mock
    private DriverRepository driverRepository;

    @Mock
    private DriverDataModelTransformer driverDataModelTransformer;

    @InjectMocks
    private DriverService driverService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testIsDriverRegistered_DriverExists() {
        // Arrange
        when(driverRepository.findByMobileNumber(anyString()))
                .thenReturn(Collections.singletonList(DriverDataModel.builder().build()));
        when(driverDataModelTransformer.buildIsDriverRegisteredResponse(anyList()))
                .thenReturn(ResponseEntity.ok(IsDriverRegisteredResponse.builder()
                                .driverInformation(GetDriverInformationResponse.builder().build())
                                .isDriverRegistered(true)
                        .build()));

        // Act
        ResponseEntity<IsDriverRegisteredResponse> response =
                driverService.isDriverRegistered("+1", "1234567890");

        // Assert
        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        IsDriverRegisteredResponse responseBody = response.getBody();
        assertNotNull(responseBody);
        assertTrue(responseBody.getIsDriverRegistered());
    }

    @Test
    void testIsDriverRegistered_DriverDoesNotExist() {
        // Arrange
        when(driverRepository.findByMobileNumber(anyString()))
                .thenReturn(Collections.emptyList());
        when(driverDataModelTransformer.buildIsDriverRegisteredResponse(anyList()))
                .thenReturn(ResponseEntity.ok(IsDriverRegisteredResponse.builder()
                        .isDriverRegistered(false)
                        .build()));

        // Act
        ResponseEntity<IsDriverRegisteredResponse> response = driverService.isDriverRegistered("+1", "1234567890");

        // Assert
        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        IsDriverRegisteredResponse responseBody = response.getBody();
        assertNotNull(responseBody);
        assertFalse(responseBody.getIsDriverRegistered());
    }

    @Test
    void testGetDriverInformation_DriverExists() {
        // Arrange
        when(driverRepository.findById(anyString())).thenReturn(Optional.of(DriverDataModel.builder().build()));
        when(driverDataModelTransformer.buildGetDriverInformationResponse(any()))
                .thenReturn(ResponseEntity.ok(GetDriverInformationResponse.builder().build()));

        // Act
        ResponseEntity<GetDriverInformationResponse> response = driverService.getDriverInformation("123");

        // Assert
        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
    }

    @Test
    void testGetDriverInformation_DriverDoesNotExist() {
        // Arrange
        when(driverRepository.findById(anyString())).thenReturn(Optional.empty());

        doThrow(IllegalArgumentException.class).when(driverControllerValidator).doesDriverExist(any(), anyString());
        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> driverService.getDriverInformation("123456"));
    }

    @Test
    void testUpdateDriverStatus() {
        // Arrange
        when(driverRepository.findById(anyString())).thenReturn(Optional.of(DriverDataModel.builder().build()));
        when(driverDataModelTransformer.createDataDriverModelWithUpdatedStatus(any(), anyString()))
                .thenReturn(DriverDataModel.builder().mobileNumber("+91-7988164534").build());

        // Act
        driverService.updateDriverStatus(UpdateDriverStatusRequest
                .builder()
                .status(UpdateDriverStatusRequest.Status.ACTIVE)
                .driverId("123")
                .build());

        // Assert
        // Verify that the repository's save method was called
        verify(driverRepository, times(1)).save(any(DriverDataModel.class));
    }

    @Test
    void testRegisterDriver() {
        // Arrange
        RegisterDriverRequest request = mock(RegisterDriverRequest.class);
        when(driverRepository.findByMobileNumber(anyString())).thenReturn(Collections.emptyList());
        when(driverDataModelTransformer.transformRegisterDriverRequest(any()))
                .thenReturn(DriverDataModel.builder().build());

        // Act
        driverService.registerDriver(request);

        // Verify that the repository's save method was called
        verify(driverRepository, times(1)).save(any(DriverDataModel.class));
    }
}
