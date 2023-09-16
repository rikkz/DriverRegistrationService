package com.intuit.DriverRegistrationService.model.entities.vehicle;

/**
 * The `CombustionType` enum represents different types of combustion for vehicles,
 * including electric, petrol, diesel, and compressed natural gas (CNG).
 */
public enum CombustionType {
    /**
     * Represents electric combustion as a type of vehicle power source.
     */
    ELECTRIC("Electric"),

    /**
     * Represents petrol combustion as a type of vehicle power source.
     */
    PETROL("Petrol"),

    /**
     * Represents diesel combustion as a type of vehicle power source.
     */
    DIESEL("Diesel"),

    /**
     * Represents compressed natural gas (CNG) combustion as a type of vehicle power source.
     */
    CNG("CNG");

    private final String combustionType;

    /**
     * Constructs a `CombustionType` enum constant with the specified combustion description.
     *
     * @param combustionType The human-readable description of the combustion type.
     */
    CombustionType(String combustionType) {
        this.combustionType = combustionType;
    }

    /**
     * Gets the human-readable description of the combustion type.
     *
     * @return The combustion description.
     */
    public String getCombustionType() {
        return combustionType;
    }
}

