package com.intuit.DriverRegistrationService.model.request;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

/**
 * Represents a request to register a vehicle.
 */
@Getter
@Builder
public class RegisterVehicleRequest {
    /**
     * Represents the driver's ID.
     */
    private String driverId;

    /**
     * Represents the type of the vehicle, which can be CAR, BIKE, AUTO_RICKSHAW, or BOAT.
     */
    private VehicleType vehicleType;

    /**
     * Represents the vehicle's registration number.
     */
    private String vehicleRegistrationNumber;

    /**
     * Represents the model of the vehicle.
     */
    private String vehicleModel;

    /**
     * Represents the manufacturer of the vehicle.
     */
    private String vehicleManufacturer;

    /**
     * Represents the validity date of the vehicle.
     */
    private Date vehicleValidity;

    /**
     * Represents the combustion type of the vehicle, which can be ELECTRIC, PETROL, CNG, or DIESEL.
     */
    private CombustionType vehicleCombustion;

    /**
     * Represents the capacity of the vehicle. Allowed values are 1, 4, 7, 3, and 15.
     */
    private Integer vehicleCapacity;

    /**
     * Represents the luxury level of the vehicle, which can be GO or PREMIER.
     */
    private VehicleLuxury vehicleLuxury;

    /**
     * Enum representing vehicle types.
     */
    public enum VehicleType {
        CAR, BIKE, AUTO_RICKSHAW, BOAT
    }

    /**
     * Enum representing combustion types.
     */
    public enum CombustionType {
        ELECTRIC, PETROL, CNG, DIESEL
    }

    /**
     * Enum representing vehicle luxury levels.
     */
    public enum VehicleLuxury {
        GO, PREMIER
    }
}
