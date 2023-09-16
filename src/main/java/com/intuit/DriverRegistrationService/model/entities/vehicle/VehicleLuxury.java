package com.intuit.DriverRegistrationService.model.entities.vehicle;

/**
 * The `VehicleLuxury` enum represents different luxury levels for vehicles, indicating their priority.
 * A smaller numerical value indicates a higher luxury priority.
 */
public enum VehicleLuxury {
    /**
     * Represents a luxury level "GO" with a priority value of 1 (lower priority).
     */
    GO(1),

    /**
     * Represents a premier luxury level with a priority value of 0 (higher priority).
     */
    PREMIER(0);

    private final int luxuryPriority;

    /**
     * Constructs a `VehicleLuxury` enum constant with the specified luxury priority.
     *
     * @param luxuryPriority The priority value indicating the luxury level.
     */
    VehicleLuxury(int luxuryPriority) {
        this.luxuryPriority = luxuryPriority;
    }

    /**
     * Gets the luxury priority value for the vehicle.
     *
     * @return The luxury priority value.
     */
    public int getLuxuryPriority() {
        return luxuryPriority;
    }
}

