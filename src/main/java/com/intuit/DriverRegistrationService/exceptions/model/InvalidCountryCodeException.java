package com.intuit.DriverRegistrationService.exceptions.model;

import com.intuit.DriverRegistrationService.exceptions.codes.BadRequestExceptionCode;

public class InvalidCountryCodeException extends BadRequestException{

    public InvalidCountryCodeException(final String requestedCountryCode) {
        super(BadRequestExceptionCode.INVALID_COUNTRY_CODE ,
                String.format("Following Country Code : %s , Doesn't exist or onboarded to our system",
                        requestedCountryCode));
    }
}
