package com.intuit.DriverRegistrationService.model.entities.address;

import lombok.Builder;

/**
 * The `Address` class represents a physical address with multiple components
 * such as address lines, city, state, and zip code.
 */
@Builder
public class Address {
    /**
     * The first line of the address, typically containing the street address.
     */
    private final String addressLine1;

    /**
     * The second line of the address, if needed to provide additional details.
     */
    private final String addressLine2;

    /**
     * The third line of the address, if needed to provide additional details.
     */
    private final String addressLine3;

    /**
     * The postal code (ZIP code) of the address.
     */
    private final String zipCode;

    /**
     * The state or region where the address is located.
     */
    private final String state;

    /**
     * The city where the address is located.
     */
    private final String city;

    /**
     * The city where the address is located.
     */
    private final String country;
}

