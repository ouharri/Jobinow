package com.ouharri.Jobinow.services.spec;

import com.ouharri.Jobinow.model.dto.requests.CompanyRequest;
import com.ouharri.Jobinow.model.dto.requests.VerificationCodeRequest;
import com.ouharri.Jobinow.model.dto.responses.CompanyResponse;

import java.util.Optional;
import java.util.UUID;

public interface CompanyServices extends _Service<UUID, CompanyRequest, CompanyResponse> {
    Optional<CompanyResponse> preCreateCompany(CompanyRequest req);

    Optional<CompanyResponse> ValidateCompany(VerificationCodeRequest req);
}
