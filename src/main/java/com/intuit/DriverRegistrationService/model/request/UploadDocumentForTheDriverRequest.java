package com.intuit.DriverRegistrationService.model.request;

import lombok.Builder;
import lombok.Getter;

/**
 * Represents a request to upload a document for a driver.
 */
@Getter
@Builder
public class UploadDocumentForTheDriverRequest {
    /**
     * The unique identifier of the driver.
     */
    private String driverId;

    /**
     * The unique identifier of the vehicle associated with the document.
     */
    private String vehicleId;

    /**
     * The URL of the uploaded document.
     */
    private String documentUrl;

    /**
     * The unique identifier of the uploaded document.
     */
    private String documentId;
}

