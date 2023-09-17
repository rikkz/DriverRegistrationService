package com.intuit.DriverRegistrationService.model.entities.driver;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * The `Person` class represents an individual with personal information such as their name,
 * date of birth, and gender.
 */
@Builder
public class Person {
    /**
     * The first name of the person.
     */
    private final String firstName;

    /**
     * The middle name of the person (if available).
     */
    private final String middleName;

    /**
     * The last name of the person.
     */
    private final String lastName;

    /**
     * The date of birth of the person.
     */
    private final Date dateOfBirth;

    /**
     * The gender of the person, represented using the `Gender` enum.
     */
    private final Gender gender;
}
