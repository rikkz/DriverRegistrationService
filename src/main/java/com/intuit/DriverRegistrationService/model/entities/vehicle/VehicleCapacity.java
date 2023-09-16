package com.intuit.DriverRegistrationService.model.entities.vehicle;

/**
 * The `VehicleCapacity` enum represents different vehicle capacities, indicating the number
 * of passengers a vehicle can accommodate.
 */
public enum VehicleCapacity {
    /**
     * Represents a normal-sized vehicle with a capacity of 4 passengers.
     */
    NORMAL(4),

    /**
     * Represents an extra-large (XL) vehicle with a capacity of 7 passengers.
     */
    XL(7),

    /**
     * Represents an auto-rickshaw with a capacity of 3 passengers.
     */
    AUTO(3),

    /**
     * Represents a bike with a capacity for 1 rider.
     */
    BIKE(1),

    /**
     * Represents a boat with a capacity of 15 passengers.
     */
    BOAT(15);

    private final int passengerCapacity;

    /**
     * Constructs a `VehicleCapacity` enum constant with the specified passenger capacity.
     *
     * @param passengerCapacity The number of passengers the vehicle can accommodate.
     */
    VehicleCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    /**
     * Gets the number of passengers the vehicle can accommodate.
     *
     * @return The passenger capacity.
     */
    public int getPassengerCapacity() {
        return passengerCapacity;
    }
}

