package com.jobinow.services.spec;

import com.jobinow.model.dto.requests.VerificationCodeRequest;
import com.jobinow.model.entities.VerificationCode;

/**
 * Service interface for managing verification codes.
 * This service defines methods for creating and validating verification codes.
 * It is responsible for handling operations related to the {@link VerificationCode} entity.
 * <p>
 * The interface is designed to work with the {@link VerificationCodeRequest} for creating
 * verification codes and validating their correctness.
 * </p>
 *
 * @version 1.0
 * @see VerificationCode
 * @see VerificationCodeRequest
 */
public interface VerificationCodeService {
    /**
     * Creates a new verification code in the system.
     *
     * @param verificationCode The verification code entity to be created.
     */
    void createVerificationCode(VerificationCode verificationCode);

    /**
     * Validates the correctness of a verification code.
     *
     * @param verificationCode The verification code request to be validated.
     * @return True if the verification code is valid, false otherwise.
     */
    Boolean isValidVerificationCode(VerificationCodeRequest verificationCode);
}