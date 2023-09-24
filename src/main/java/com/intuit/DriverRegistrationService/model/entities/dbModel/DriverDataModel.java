package com.intuit.DriverRegistrationService.model.entities.dbModel;

import com.intuit.DriverRegistrationService.model.entities.address.AddressBook;
import com.intuit.DriverRegistrationService.model.entities.driver.DriverStatus;
import com.intuit.DriverRegistrationService.model.entities.driver.Person;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * The `DriverDataModel` class represents a data model for storing information about a driver.
 * It encapsulates details such as driver ID, status, contact information, address book,
 * and personal information.
 */
@Builder
@Getter
@Document(collection = "Driver")
public class DriverDataModel {
    /**
     * The unique identifier for the driver.
     */
    @Id
    private final String driverId;

    /**
     * The current status of the driver, represented using the `DriverStatus` enum.
     */
    private final DriverStatus driverStatus;

    /**
     * The email address of the individual.
     */
    private final String emailId;
    /**
     * The country code and the combined individual's phone number
     */
    private final String mobileNumber;

    /**
     * The address book of the driver, containing current and permanent addresses.
     */
    private final AddressBook driverAddressBook;

    /**
     * The personal information of the driver, including name and date of birth.
     */
    private final Person driverPersonalInformation;

    /**
     * Represents the Location of the Driver, in COUNTRY:STATE:CITY format.
     */
    private final String driverLocation;

    private List<VehicleDataModel> driverVehicles;

    private List<Document> documents;

}
