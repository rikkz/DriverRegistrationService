package com.intuit.DriverRegistrationService.model.entities.driver;

/**
 * The `GENDER` enum represents a set of gender values with associated string representations.
 * It is designed to be used when you need to work with gender information in your application.
 */
public enum Gender {
    /**
     * The MALE gender constant represents the male gender.
     */
    MALE("MALE"),

    /**
     * The FEMALE gender constant represents the female gender.
     */
    FEMALE("FEMALE"),

    /**
     * The OTHER gender constant represents a gender that is not strictly male or female.
     */
    OTHER("OTHER");

    private final String genderValue;

    /**
     * Constructs a `GENDER` enum constant with the specified gender value.
     *
     * @param genderValue The string representation of the gender.
     */
    Gender(String genderValue) {
        this.genderValue = genderValue;
    }

    /**
     * Gets the string representation of the gender.
     *
     * @return The string representation of the gender.
     */
    public String getGender() {
        return genderValue;
    }
}

