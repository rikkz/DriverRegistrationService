package com.intuit.DriverRegistrationService.validations;

import com.intuit.DriverRegistrationService.config.CountryDigitsMapConfig;
import com.intuit.DriverRegistrationService.exceptions.model.InvalidCountryCodeException;
import com.intuit.DriverRegistrationService.exceptions.model.InvalidMobileNumberException;
import com.intuit.DriverRegistrationService.model.request.IsDriverRegisteredRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.Map;

@Controller
@AllArgsConstructor
public class DriverControllerValidator {
    private final CountryDigitsMapConfig countryDigitsMapConfig;

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
