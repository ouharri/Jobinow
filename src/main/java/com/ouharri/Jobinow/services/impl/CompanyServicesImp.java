package com.ouharri.Jobinow.services.impl;

import com.ouharri.Jobinow.events.CompanyCreatedEvent;
import com.ouharri.Jobinow.exceptions.ResourceNotCreatedException;
import com.ouharri.Jobinow.model.dto.requests.CompanyRequest;
import com.ouharri.Jobinow.model.dto.requests.VerificationCodeRequest;
import com.ouharri.Jobinow.model.dto.responses.CompanyResponse;
import com.ouharri.Jobinow.model.entities.Company;
import com.ouharri.Jobinow.model.entities.VerificationCode;
import com.ouharri.Jobinow.model.enums.CompanyStatus;
import com.ouharri.Jobinow.model.mapper.CompanyMapper;
import com.ouharri.Jobinow.repositories.CompanyRepository;
import com.ouharri.Jobinow.services.spec.CompanyServices;
import com.ouharri.Jobinow.services.spec.VerificationCodeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
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
