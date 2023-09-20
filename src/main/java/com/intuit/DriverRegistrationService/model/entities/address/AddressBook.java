package com.intuit.DriverRegistrationService.model.entities.address;

import lombok.Builder;
import lombok.Getter;

/**
 * The `AddressBook` class represents a collection of addresses for an individual,
 * including their current address and permanent address.
 */
@Builder
@Getter
public class AddressBook {
    /**
     * The current address of the individual.
     */
    private final Address currentAddress;

    /**
     * The permanent address of the individual.
     */
    private final Address permanentAddress;
}