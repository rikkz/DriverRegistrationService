package com.intuit.DriverRegistrationService.validations;

import com.intuit.DriverRegistrationService.config.CountryDigitsMapConfig;
import com.intuit.DriverRegistrationService.exceptions.model.InvalidCountryCodeException;
import com.intuit.DriverRegistrationService.exceptions.model.InvalidMobileNumberException;
import com.intuit.DriverRegistrationService.model.request.IsDriverRegisteredRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.Map;

/**
 * Controller class responsible for validating driver-related requests.
 * It performs validation checks on driver registration requests, ensuring that provided data is valid.
 */
@Component
@AllArgsConstructor
public class DriverControllerValidator {

    /**
     * Configuration bean providing a mapping of country codes to the expected number of digits in their mobile numbers.
     */
    private final CountryDigitsMapConfig countryDigitsMapConfig;

    /**
     * Validates an {@code IsDriverRegisteredRequest} object to ensure it meets the required criteria for driver
     * registration verification.
     * Throws exceptions for invalid country codes or mobile number lengths.
     *
     * @param isDriverRegisteredRequest The request object to be validated.
     * @throws InvalidCountryCodeException If the provided country code is invalid or not onboarded to the system.
     * @throws InvalidMobileNumberException If the provided mobile number does not match the expected length for the
     * corresponding country code.
     */
    public void validateIsUserRegisteredRequest(final IsDriverRegisteredRequest isDriverRegisteredRequest) {

        String requestedCountryCode = isDriverRegisteredRequest.getCountryCode();
        String requestedMobileNumber = isDriverRegisteredRequest.getMobileNumber();

        Map<String, Integer> countryDigitsMap = countryDigitsMapConfig.countryToDigitsMap();

        if(!countryDigitsMap.containsKey(requestedCountryCode)) {
            throw new InvalidCountryCodeException(requestedCountryCode);
        }

        int requiredNumberLength = countryDigitsMap.get(requestedCountryCode);

        if (requiredNumberLength != requestedMobileNumber.length()) {
            throw new InvalidMobileNumberException(requestedMobileNumber);
        }
    }
}
