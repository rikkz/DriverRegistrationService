package com.intuit.DriverRegistrationService.model.request.common;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;


/**
 * Represents the driver's name, including first name, middle name, and last name.
 */
@Getter
@Builder
public class Name {
    /**
     * Represents the first name of the driver.
     */
    @Size(min = 1, max = 1, message = "First name length must be between 1 and 20 characters")
    private String firstName;

    /**
     * Represents the middle name of the driver.
     */
    private String middleName;

    /**
     * Represents the last name of the driver.
     */
    @NotBlank
    @NonNull
    @Size(min = 1, max = 20, message = "Last name length must be between 1 and 20 characters")
    private String lastName;
}
