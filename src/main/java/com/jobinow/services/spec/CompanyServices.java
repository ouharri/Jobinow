package com.jobinow.services.spec;

import com.jobinow.model.dto.requests.CompanyRequest;
import com.jobinow.model.dto.requests.VerificationCodeRequest;
import com.jobinow.model.dto.responses.CompanyResponse;

import java.security.SecureRandom;
import java.util.Optional;
import java.util.UUID;

/**
 * Service interface for managing company-related operations.
 * This service extends the generic service interface {@link _Service},
 * specializing in operations related to company entities.
 * It defines methods for creating, retrieving, validating, and handling
 * other aspects of company data.
 * <p>
 * The interface is designed to work with UUID as the identifier type for company entities.
 * </p>
 *
 * @author Your Name
 * @version 1.0
 * @see CompanyRequest
 * @see VerificationCodeRequest
 * @see CompanyResponse
 * @see _Service
 */
public interface CompanyServices extends _Service<UUID, CompanyRequest, CompanyResponse> {

    /**
     * Pre-creates a company based on the provided request.
     * This method performs preliminary operations before the actual creation of the company.
     *
     * @param req The request containing company details.
     * @return An optional containing the pre-created company response if successful, otherwise empty.
     */
    Optional<CompanyResponse> preCreateCompany(CompanyRequest req);

    /**
     * Validates a company based on the provided verification code request.
     *
     * @param req The request containing the verification code.
     * @return An optional containing the validated company response if successful, otherwise empty.
     */
    Optional<CompanyResponse> ValidateCompany(VerificationCodeRequest req);

    /**
     * Generates a random verification code.
     *
     * @return The generated random verification code.
     */
    default int generateRandomCode() {
        SecureRandom random = new SecureRandom();
        int min = (int) Math.pow(10, 6 - 1);
        int max = (int) Math.pow(10, 6) - 1;
        return min + random.nextInt(max - min + 1);
    }
}