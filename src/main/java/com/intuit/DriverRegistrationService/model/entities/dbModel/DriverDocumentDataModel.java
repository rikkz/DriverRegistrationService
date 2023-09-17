package com.intuit.DriverRegistrationService.model.entities.dbModel;

import com.intuit.DriverRegistrationService.model.entities.document.Document;
import lombok.Builder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * The `DriverDocumentDataModel` class represents a data model that associates driver-related
 * documents, a driver's unique identifier, a list of documents, and a vehicle identifier.
 */
@Builder
public class DriverDocumentDataModel {
    /**
     * The unique identifier for the driver.
     */
    private final String driverId;

    /**
     * A list of documents associated with the driver, typically including documents such as
     * licenses, certifications, and identification.
     */
    private final List<Document> documentList;

    /**
     * The identifier of the vehicle associated with the driver (if applicable).
     */
    private final String vehicleId;

    public static DriverDocumentDataModelBuilder builder(Collection<Document> documentList) {
        return new DriverDocumentDataModelBuilder()
                .documentList(new ArrayList<>(documentList)); // Perform a defensive copy
    }
}