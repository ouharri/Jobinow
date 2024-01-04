package com.jobinow.services.spec;

import com.jobinow.model.dto.requests.CompanyRequest;
import com.jobinow.model.dto.requests.VerificationCodeRequest;
import com.jobinow.model.dto.responses.CompanyResponse;

import java.util.Optional;
import java.util.UUID;

public interface CompanyServices extends _Service<UUID, CompanyRequest, CompanyResponse> {
    Optional<CompanyResponse> preCreateCompany(CompanyRequest req);

    Optional<CompanyResponse> ValidateCompany(VerificationCodeRequest req);
}
