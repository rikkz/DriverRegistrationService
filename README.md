# Driver Onboarding Module for Ride Management Application

Welcome to the Driver Onboarding Module for a ride management application, similar to Uber. This module is designed to facilitate the onboarding process for prospective drivers who wish to become driver partners in our platform. It encompasses various functionalities to streamline the driver registration process, manage driver profiles, verify driver information, and handle document uploads. Additionally, it includes workflows triggered by document updates, ensuring seamless communication with necessary services.

## Project Details

The Driver Onboarding Module includes the following key functionalities:

1. **Driver Registration Service**: This service handles the registration process for new drivers, allowing them to sign up as driver partners.

2. **Driver Profile Information**: Provides operations for creating, updating, and reading driver profile information, ensuring accurate and up-to-date records.

3. **Driver Verification**: Manages the rules and processes required to verify driver credentials and eligibility.

4. **Document Upload**: Allows drivers to upload necessary documents for verification purposes.

5. **Driver Status Updates**: Enables the updating of driver status, reflecting changes in their availability or eligibility.

6. **Post-Workflow Triggering**: Initiates post-workflows in response to document updates, ensuring coordination with other essential services.

## Getting Started

To build the project, use the following command:

```bash
./gradlew build
```

To run the tests, use:

```bash
./gradlew test
```

To deploy locally

```bash
./gradlew bootRun
```


## Prerequisites
Make sure you have MongoDB Community Edition installed, as the application relies on it for data storage.

## Usage
Detailed usage instructions and API documentation will be provided separately in the project documentation. The API endpoints and expected request/response formats will be documented to help you integrate this module with the ride management application.

## Use Swagger
```agsl
https://localhost:8443/swagger-ui/index.html
```