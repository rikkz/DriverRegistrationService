package com.intuit.DriverRegistrationService.model.entities.driver;

/**
 * The `DriverStatus` enum represents various statuses that a driver can have.
 * These statuses describe the current state or condition of the driver's account
 * or activities within a transportation system or service.
 */
public enum DriverStatus {
    /**
     * The driver is actively available and can accept service requests.
     */
    ACTIVE("Active"),

    /**
     * The driver is not active and is currently unavailable for service requests.
     */
    NOT_ACTIVE("Not Active"),

    /**
     * The driver's account has been suspended, temporarily restricting their access.
     */
    SUSPENDED("Suspended"),

    /**
     * The driver's account has been terminated, and they no longer have access.
     */
    TERMINATED("Terminated"),

    /**
     * The driver's registration is pending approval or completion.
     */
    REGISTRATION_PENDING("Registration Pending"),

    /**
     * The driver's verification process is pending, and they need to be verified
     * before becoming active.
     */
    VERIFICATION_PENDING("Verification Pending");

    private final String status;

    /**
     * Constructs a `DriverStatus` enum constant with the specified status description.
     *
     * @param status The human-readable description of the driver status.
     */
    DriverStatus(final String status) {
        this.status = status;
    }

    /**
     * Gets the human-readable description of the driver status.
     *
     * @return The status description.
     */
    public String getStatus() {
        return status;
    }
}
