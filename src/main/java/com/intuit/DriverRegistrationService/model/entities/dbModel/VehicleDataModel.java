package com.intuit.DriverRegistrationService.model.entities.dbModel;

import com.intuit.DriverRegistrationService.model.entities.vehicle.CombustionType;
import com.intuit.DriverRegistrationService.model.entities.vehicle.VehicleCapacity;
import com.intuit.DriverRegistrationService.model.entities.vehicle.VehicleLuxury;
import com.intuit.DriverRegistrationService.model.entities.vehicle.VehicleType;
import lombok.Builder;

import java.util.Date;


/**
 * The `VehicleDataModel` class represents a data model for storing information about a vehicle,
 * including its unique identifier, driver's identifier, type, registration number, model,
 * manufacturer, validity, combustion type, luxury level, and passenger capacity.
 */
@Builder
public class VehicleDataModel {

    /**
     * The unique identifier for the vehicle.
     */
    private final String vehicleId;

    /**
     * The unique identifier for the driver associated with the vehicle.
     */
    private final String driverId;

    /**
     * The type of the vehicle, represented using the `VehicleType` enum.
     */
    private final VehicleType vehicleType;

    /**
     * The unique registration number of the vehicle.
     */
    private final String vehicleRegistrationNumber;

    /**
     * The model of the vehicle.
     */
    private final String vehicleModel;

    /**
     * The manufacturer of the vehicle.
     */
    private final String vehicleManufacturer;

    /**
     * The validity date of the vehicle, indicating when it is valid or expires.
     */
    private final Date vehicleValidity;

    /**
     * The combustion type of the vehicle, represented using the `CombustionType` enum.
     */
    private final CombustionType combustionType;

    /**
     * The luxury level of the vehicle, representing the `VehicleLuxury` enum.
     */
    private final VehicleLuxury vehicleLuxury;

    /**
     * The passenger capacity of the vehicle, representing the `VehicleCapacity` enum.
     */
    private final VehicleCapacity vehicleCapacity;
}