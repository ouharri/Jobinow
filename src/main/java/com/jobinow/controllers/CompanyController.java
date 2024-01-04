package com.jobinow.controllers;

import com.jobinow.model.dto.requests.CompanyRequest;
import com.jobinow.model.dto.requests.VerificationCodeRequest;
import com.jobinow.model.dto.responses.CompanyResponse;
import com.jobinow.services.spec.CompanyServices;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Validated
@RestController
@RequestMapping("api/v2/company")
public class CompanyController extends _Controller<UUID, CompanyRequest, CompanyResponse, CompanyServices> {

    @Override
    @PostMapping
    public ResponseEntity<CompanyResponse> create(
            @Valid @RequestBody CompanyRequest request,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors())
            handleValidationError(bindingResult);

        Optional<CompanyResponse> response = service.preCreateCompany(request);

        return response.map(ResponseEntity::ok).orElseGet(() ->
                ResponseEntity.badRequest().build());
    }

    @PostMapping("/validate")
    public ResponseEntity<CompanyResponse> validate(
            @Valid @RequestBody VerificationCodeRequest request,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors())
            handleValidationError(bindingResult);

        Optional<CompanyResponse> response = service.ValidateCompany(request);

        return response.map(ResponseEntity::ok).orElseGet(() ->
                ResponseEntity.badRequest().build());
    }
}
