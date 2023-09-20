package com.intuit.DriverRegistrationService.model.request.common;

import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Getter
@Builder
public class Address {
    /**
     * Represents the first line of the address.
     */
    @NonNull
    @Size(min = 5, max = 100, message = "AddressLine 1 length must be between 5 and 100 characters")
    private String addressLine1;

    /**
     * Represents the second line of the address.
     */
    @Size(max = 100, message = "AddressLine 2 length must be max 100 characters")
    private String addressLine2;

    /**
     * Represents the third line of the address.
     */
    @Size(max = 100, message = "AddressLine 3 length must be max 100 characters")
    private String addressLine3;

    /**
     * Represents the state of the address.
     */
    @NonNull
    @Size(min = 5, max = 20, message = "State length must be between 5 and 20 characters")
    private String state;

    /**
     * Represents the country of the address.
     */
    @NonNull
    @Size(min = 5, max = 30, message = "Country length must be between 5 and 30 characters")
    private String country;

    /**
     * Represents the country of the address.
     */
    @NonNull
    @Size(min = 5, max = 30, message = "City length must be between 5 and 30 characters")
    private String city;

    /**
     * Represents the zip code of the address.
     */
    @NonNull
    @Size(min = 5, max = 10, message = "ZipCode length must be between 5 and 10 characters")
    private String zipCode;
}
