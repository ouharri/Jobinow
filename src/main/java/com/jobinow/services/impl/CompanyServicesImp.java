package com.jobinow.services.impl;

import com.jobinow.events.CompanyCreatedEvent;
import com.jobinow.exceptions.ResourceNotCreatedException;
import com.jobinow.model.entities.Company;
import com.jobinow.model.entities.VerificationCode;
import com.jobinow.services.spec.CompanyServices;
import com.jobinow.services.spec.VerificationCodeService;
import com.jobinow.model.dto.requests.CompanyRequest;
import com.jobinow.model.dto.requests.VerificationCodeRequest;
import com.jobinow.model.dto.responses.CompanyResponse;
import com.jobinow.model.enums.CompanyStatus;
import com.jobinow.model.mapper.CompanyMapper;
import com.jobinow.repositories.CompanyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.SecureRandom;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class CompanyServicesImp extends _ServiceImp<UUID, CompanyRequest, CompanyResponse, Company, CompanyRepository, CompanyMapper> implements CompanyServices {

    private final ApplicationEventPublisher eventPublisher;
    private final VerificationCodeService verificationCodeService;

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

    public Optional<CompanyResponse> ValidateCompany(VerificationCodeRequest req) {
        if (verificationCodeService.isValidVerificationCode(req)) {
            Company companyToSave = mapper.toEntityFromResponse(req.company());
            companyToSave.setStatus(CompanyStatus.APPROVED);
            Company createdCompany = repository.saveAndFlush(companyToSave);
            return Optional.of(mapper.toResponse(createdCompany));
        }
        return Optional.empty();
    }

    private static int generateRandomCode() {
        SecureRandom random = new SecureRandom();
        int min = (int) Math.pow(10, 6 - 1);
        int max = (int) Math.pow(10, 6) - 1;
        return min + random.nextInt(max - min + 1);
    }
}
