package com.jobinow.services.impl;

import com.jobinow.events.CompanyCreatedEvent;
import com.jobinow.exceptions.ResourceNotCreatedException;
import com.jobinow.model.dto.requests.CompanyRequest;
import com.jobinow.model.dto.requests.VerificationCodeRequest;
import com.jobinow.model.dto.responses.CompanyResponse;
import com.jobinow.model.entities.Company;
import com.jobinow.model.entities.VerificationCode;
import com.jobinow.model.enums.CompanyStatus;
import com.jobinow.model.mapper.CompanyMapper;
import com.jobinow.repositories.CompanyRepository;
import com.jobinow.services.spec.CompanyServices;
import com.jobinow.services.spec.VerificationCodeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.SecureRandom;
import java.util.Optional;
import java.util.UUID;

/**
 * Service implementation class for managing companies.
 * This service provides methods for creating, validating, and handling operations related to {@link Company}.
 * It extends the generic service implementation ({@link _ServiceImp}) and implements custom methods for
 * pre-creating and validating companies, including the generation and handling of verification codes.
 * <p>
 * The class uses the {@link CompanyMapper} for mapping between entities and DTOs.
 * </p>
 *
 * @author  <a href="mailto:ouharrioutman@gmail.com">ouharri outman</a>
 * @version 1.0
 * @see _ServiceImp
 * @see Company
 * @see CompanyRequest
 * @see CompanyResponse
 * @see CompanyMapper
 * @see VerificationCodeService
 * @see VerificationCode
 * @see CompanyCreatedEvent
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class CompanyServicesImp extends _ServiceImp<UUID, CompanyRequest, CompanyResponse, Company, CompanyRepository, CompanyMapper> implements CompanyServices {

    private final ApplicationEventPublisher eventPublisher;
    private final VerificationCodeService verificationCodeService;

    /**
     * Attempts to pre-create a company by saving it to the repository, generating a verification code,
     * and publishing a {@link CompanyCreatedEvent}. If successful, returns the created company as a response.
     *
     * @param req The company request containing details for pre-creating the company.
     * @return An optional containing the created company response, or empty if the operation fails.
     * @throws ResourceNotCreatedException If an error occurs during the creation process.
     */
    @Transactional
    public Optional<CompanyResponse> preCreateCompany(CompanyRequest req) {
        Company companyToSave = mapper.toEntityFromRequest(req);
        try {
            Company createdCompany = repository.saveAndFlush(companyToSave);
            VerificationCode verificationCode = VerificationCode
                    .builder()
                    .code(Integer.toString(generateRandomCode()))
                    .company(createdCompany)
                    .build();
            verificationCodeService.createVerificationCode(verificationCode);
            eventPublisher.publishEvent(new CompanyCreatedEvent(verificationCode));
            return Optional.of(mapper.toResponse(createdCompany));
        } catch (Exception e) {
            log.error("Error while creating entity", e);
            throw new ResourceNotCreatedException(e.getMessage());
        }
    }

    /**
     * Validates a company by checking the provided verification code.
     * If the code is valid, updates the company status to APPROVED and returns the response.
     *
     * @param req The verification code request containing the company and verification code.
     * @return An optional containing the validated company response, or empty if validation fails.
     */
    public Optional<CompanyResponse> ValidateCompany(VerificationCodeRequest req) {
        if (verificationCodeService.isValidVerificationCode(req)) {
            Company companyToSave = mapper.toEntityFromResponse(req.company());
            companyToSave.setStatus(CompanyStatus.APPROVED);
            Company createdCompany = repository.saveAndFlush(companyToSave);
            return Optional.of(mapper.toResponse(createdCompany));
        }
        return Optional.empty();
    }
}
