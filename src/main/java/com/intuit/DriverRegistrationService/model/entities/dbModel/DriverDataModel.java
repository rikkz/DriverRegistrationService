package com.intuit.DriverRegistrationService.model.entities.dbModel;

import com.intuit.DriverRegistrationService.model.entities.driver.Contact;
import com.intuit.DriverRegistrationService.model.entities.driver.DriverStatus;
import com.intuit.DriverRegistrationService.model.entities.driver.Person;
import com.intuit.DriverRegistrationService.model.entities.address.AddressBook;
import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * The `DriverDataModel` class represents a data model for storing information about a driver.
 * It encapsulates details such as driver ID, status, contact information, address book,
 * and personal information.
 */
@Builder
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
     * The contact information of the driver, including email, country code, and mobile number.
     */
    private final Contact driverContact;

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
}
