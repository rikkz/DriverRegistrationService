package com.intuit.DriverRegistrationService.model.entities.document;

import lombok.Builder;

/**
 * The `Document` class represents a document with details such as its unique identifier,
 * status (e.g., approved, rejected, uploaded), rejection reason (if applicable), and
 * the URL where the document is stored (e.g., on an S3 bucket).
 */
@Builder
public class Document {
    /**
     * The unique identifier for the document.
     */
    private final String documentId;

    /**
     * The status of the document, represented using the `DocumentStatus` enum.
     */
    private final DocumentStatus documentStatus;

    /**
     * The reason for rejecting the document (if it has been rejected).
     * This field may be null if the document is approved or not uploaded.
     */
    private final String rejectionReason;

    /**
     * The URL where the document is stored, typically on an S3 bucket or a similar service.
     */
    private final String documentS3Url;
}
