package com.intuit.DriverRegistrationService.model.response;

import com.intuit.DriverRegistrationService.model.entities.address.AddressBook;
import com.intuit.DriverRegistrationService.model.entities.driver.Contact;
import com.intuit.DriverRegistrationService.model.entities.driver.Person;
import lombok.Builder;

@Builder
public class GetDriverInformationResponse {
    private final String driverId;
    private final String driverStatus;
    private final Contact contact;
    private final AddressBook addressBook;
    private final Person person;
}
