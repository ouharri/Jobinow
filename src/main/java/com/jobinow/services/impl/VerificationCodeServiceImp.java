package com.jobinow.services.impl;

import com.jobinow.exceptions.ResourceNotCreatedException;
import com.jobinow.model.dto.requests.VerificationCodeRequest;
import com.jobinow.model.entities.Company;
import com.jobinow.model.entities.VerificationCode;
import com.jobinow.model.mapper.VerificationCodeMapper;
import com.jobinow.repositories.VerificationCodeRepository;
import com.jobinow.services.spec.VerificationCodeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Service implementation class for managing verification codes.
 * This service provides methods for creating and validating verification codes.
 * It handles operations related to {@link VerificationCode}, such as creating and checking the validity
 * of verification codes associated with a specific {@link Company}.
 * <p>
 * The class uses the specified repository ({@link VerificationCodeRepository}) for data access
 * and leverages the {@link VerificationCodeMapper} for mapping between entities and DTOs.
 * </p>
 *
 * @version 1.0
 * @see VerificationCodeService
 * @see VerificationCode
 * @see VerificationCodeRequest
 * @see VerificationCodeMapper
 * @see VerificationCodeRepository
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class VerificationCodeServiceImp implements VerificationCodeService {

    private final VerificationCodeMapper mapper;
    private final VerificationCodeRepository repository;

    /**
     * Creates a new verification code in the repository.
     *
     * @param verificationCode The verification code to be created
     * @throws ResourceNotCreatedException If an error occurs while creating the verification code
     */
    public void createVerificationCode(VerificationCode verificationCode) {
        try {
            repository.saveAndFlush(verificationCode);
        } catch (Exception e) {
            log.error("Error while creating VerificationCode", e);
            throw new ResourceNotCreatedException(e.getMessage());
        }
    }

    /**
     * Checks the validity of a verification code.
     *
     * @param verificationCode The verification code to be validated
     * @return {@code true} if the verification code is valid, {@code false} otherwise
     */
    public Boolean isValidVerificationCode(VerificationCodeRequest verificationCode) {
        VerificationCode verificationCodeToCreate = mapper.toEntityFromRequest(verificationCode);
        return repository.isValidVerificationCode(
                verificationCodeToCreate.getCode(),
                verificationCodeToCreate.getCompany().getId()
        );
    }
}