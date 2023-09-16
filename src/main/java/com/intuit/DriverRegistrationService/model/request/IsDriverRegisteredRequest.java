package com.intuit.DriverRegistrationService.model.request;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class IsDriverRegisteredRequest {
    private String countryCode;
    private String mobileNumber;
}
