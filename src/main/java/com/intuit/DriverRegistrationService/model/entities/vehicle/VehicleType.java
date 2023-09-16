package com.intuit.DriverRegistrationService.model.entities.vehicle;

/**
 * The `VehicleType` enum represents different types of vehicles, such as cars, bikes,
 * auto-rickshaws, and boats.
 */
public enum VehicleType {
    /**
     * Represents a car as a type of vehicle.
     */
    CAR("Car"),

    /**
     * Represents a bike as a type of vehicle.
     */
    BIKE("Bike"),

    /**
     * Represents an auto-rickshaw as a type of vehicle.
     */
    AUTO_RICKSHAW("Auto Rickshaw"),

    /**
     * Represents a boat as a type of vehicle.
     */
    BOAT("Boat");

    private final String type;

    /**
     * Constructs a `VehicleType` enum constant with the specified type description.
     *
     * @param type The human-readable description of the vehicle type.
     */
    VehicleType(String type) {
        this.type = type;
    }

    /**
     * Gets the human-readable description of the vehicle type.
     *
     * @return The type description.
     */
    public String getType() {
        return type;
    }
}

