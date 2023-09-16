package com.intuit.DriverRegistrationService.model.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class IsDriverRegisteredResponse {
    private final Boolean isDriverRegistered;
}
