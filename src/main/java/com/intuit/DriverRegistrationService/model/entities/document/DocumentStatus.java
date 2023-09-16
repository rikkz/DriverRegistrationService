package com.intuit.DriverRegistrationService.model.entities.document;

/**
 * The `DocumentStatus` enum represents the status of a document, indicating whether it has
 * been uploaded, approved, rejected, or not uploaded.
 */
public enum DocumentStatus {
    /**
     * The document has been approved.
     */
    APPROVED("Approved"),

    /**
     * The document has been rejected.
     */
    REJECTED("Rejected"),

    /**
     * The document has not been uploaded.
     */
    NOT_UPLOADED("Not Uploaded"),

    /**
     * The document has been uploaded but its status is pending approval.
     */
    UPLOADED("Uploaded");

    private final String status;

    /**
     * Constructs a `DocumentStatus` enum constant with the specified status description.
     *
     * @param status The human-readable description of the document status.
     */
    DocumentStatus(String status) {
        this.status = status;
    }

    /**
     * Gets the human-readable description of the document status.
     *
     * @return The status description.
     */
    public String getStatus() {
        return status;
    }
}
