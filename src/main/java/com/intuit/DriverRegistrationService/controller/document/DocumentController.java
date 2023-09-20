package com.intuit.DriverRegistrationService.controller.document;

import com.intuit.DriverRegistrationService.model.request.DocumentRequiredForVehicleRegistrationRequest;
import com.intuit.DriverRegistrationService.model.request.UploadDocumentForTheDriverRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for handling document-related operations in the Driver Registration Service API.
 * This class defines endpoints to get required documents against vehicle information and upload it.
 */
@RestController
@RequestMapping("/api/document")
@Slf4j
public class DocumentController {

    /**
     * Handles a POST request to get the  document required uploading to complete the Vehicle registration.
     *
     * @param documentRequiredForVehicleRegistrationRequest The request body containing requested DriverId and VehicleId.
     */
    @PostMapping("/getDocumentRequiredForVehicleRegistration")
    public void getDocumentRequiredForVehicleRegistration (
            @RequestBody final DocumentRequiredForVehicleRegistrationRequest
                    documentRequiredForVehicleRegistrationRequest) {
        log.info("Starting the getDocumentRequiredForVehicleRegistration Journey");
        //TODO : Complete the implementation for the Rest API
    }

    /**
     * Handles a POST request to upload the document for the requested vehicle.
     *
     * @param uploadDocumentForTheDriverRequest The request body containing document url needs to be uploaded.
     */
    @PostMapping("/uploadDocumentForTheDriver")
    public void uploadDocumentForTheDriver (
            @RequestBody final UploadDocumentForTheDriverRequest uploadDocumentForTheDriverRequest) {
        log.info("Starting the uploadDocumentForTheDriverRequest Journey");
        //TODO : Complete the implementation for the Rest API
    }

}
