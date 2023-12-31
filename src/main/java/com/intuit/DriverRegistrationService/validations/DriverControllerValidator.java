package com.intuit.DriverRegistrationService.validations;

import com.intuit.DriverRegistrationService.config.CountryDigitsMapConfig;
import com.intuit.DriverRegistrationService.exceptions.codes.BadRequestExceptionCode;
import com.intuit.DriverRegistrationService.exceptions.model.*;
import com.intuit.DriverRegistrationService.exceptions.service.DriverAlreadyExistInTheDB;
import com.intuit.DriverRegistrationService.exceptions.service.DriverDoesNotExistInTheDB;
import com.intuit.DriverRegistrationService.model.entities.dbModel.DriverDataModel;
import com.intuit.DriverRegistrationService.model.request.common.Address;
import com.intuit.DriverRegistrationService.model.request.common.Name;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
     * @param requestedCountryCode , requestedMobileNumber The request object to be validated.
     * @throws InvalidCountryCodeException If the provided country code is invalid or not onboarded to the system.
     * @throws InvalidMobileNumberException If the provided mobile number does not match the expected length for the
     * corresponding country code.
     */
    public void validateMobileNumber(final String requestedCountryCode,
                                                final String requestedMobileNumber) {

        Map<String, Integer> countryDigitsMap = countryDigitsMapConfig.countryToDigitsMap();

        validateCountryCode(requestedCountryCode, countryDigitsMap);
        validateMobileNumber(requestedMobileNumber, requestedCountryCode, countryDigitsMap);
    }

    private void validateCountryCode(final String requestedCountryCode,
                                        final Map<String, Integer> countryDigitsMap) {

        if (!countryDigitsMap.containsKey(requestedCountryCode)) {
                throw new InvalidCountryCodeException(
                        String.format("Following Country Code : %s , Doesn't exist or onboarded to our system",
                        requestedCountryCode));
            }
    }

    private void validateMobileNumber(final String requestedMobileNumber,
                                         final String requestedCountryCode,
                                         final Map<String, Integer> countryDigitsMap) {
        int requiredNumberLength = countryDigitsMap.get(requestedCountryCode);

        if (requiredNumberLength != requestedMobileNumber.length() || !requestedMobileNumber.matches("\\d+")) {
            throw new InvalidMobileNumberException(
                    String.format("Following Mobile Number : %s is not valid, it either doesn't contain valid length or digits",
                            requestedMobileNumber));
        }
    }

    public void isValidDriverId(final String driverId) {
        if(!driverId.contains("DR")) {
            throw new InvalidDriverIdException(
                       String.format("Following Driver Id : %s is not valid, It's not in correct format", driverId));
        }
    }
    public void doesDriverExist(final Optional<DriverDataModel> driverDataModelOptional,
                                final String driverId) {
       if(!doesDriverExist(driverDataModelOptional)) {
           throw new DriverDoesNotExistInTheDB(
                   String.format("Following Driver Id : %s is not valid, It doesn't exist in system", driverId));
       }
    }

    /**
     * Driver should not exist in the system.
     * @param driverDataModelList
     */
    public void driverShouldNotExist(final List<DriverDataModel> driverDataModelList) {
        if(driverDataModelList.size() > 0) {
            throw new DriverAlreadyExistInTheDB(
                    String.format("Following Driver already exist in system"));
        }
    }

    private boolean doesDriverExist(final Optional<DriverDataModel> driverDataModelOptional) {
        return driverDataModelOptional.isPresent();
    }

    public void validateEmail(final String requestedEmailId) {
        // It's not a mandatory field.
        if(requestedEmailId == null) {
            return;
        }

        if (!EmailValidator.getInstance().isValid(requestedEmailId)) {
            throw new InvalidEmailAddressException(
                    String.format("Following Email Id : %s is not valid, It's not in correct format",
                            requestedEmailId));
        }
    }

    public void validateAge(final LocalDate birthDate) {
        // It's not a mandatory field.
        LocalDate minDate = LocalDate.now().minusYears(18);
        LocalDate maxDate = LocalDate.now().minusYears(100);



        if (!birthDate.isBefore(minDate) || birthDate.isBefore(maxDate)) {
            throw new InvalidAgeException(
                    String.format("Following Age : %s is not valid, It's should be between 18 to 100 years",
                            birthDate));
        }
    }

    public void validateName(final Name name) {
        if (StringUtils.isAllEmpty(name.getFirstName()) || name.getFirstName().length() > 21) {
            throw new BadRequestException(BadRequestExceptionCode.INVALID_NAME, "Please verify  first name");
        }

        if (StringUtils.isAllEmpty(name.getLastName()) || name.getLastName().length() > 21) {
            throw new BadRequestException(BadRequestExceptionCode.INVALID_NAME, "Please verify lastName");
        }
    }

    public void validateAddress(final Address address) {
        if (StringUtils.isAllEmpty(address.getAddressLine1()) || address.getAddressLine1().length() > 21) {
            throw new BadRequestException(BadRequestExceptionCode.INVALID_ADDRESS, "Please verify address Line 1");
        }

        if (StringUtils.isAllEmpty(address.getState()) || address.getState().length() > 21) {
            throw new BadRequestException(BadRequestExceptionCode.INVALID_ADDRESS, "Please verify address state");
        }

        if (StringUtils.isAllEmpty(address.getCity()) || address.getCity().length() > 21) {
            throw new BadRequestException(BadRequestExceptionCode.INVALID_ADDRESS, "Please verify address city");
        }

        if (StringUtils.isAllEmpty(address.getCountry()) || address.getCountry().length() > 21) {
            throw new BadRequestException(BadRequestExceptionCode.INVALID_ADDRESS, "Please verify address country");
        }

        if (StringUtils.isAllEmpty(address.getZipCode()) || address.getZipCode().length() > 21) {
            throw new BadRequestException(BadRequestExceptionCode.INVALID_ADDRESS, "Please verify address zipcode");
        }
    }
}
