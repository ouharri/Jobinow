package com.jobinow.services.impl;

import com.jobinow.model.dto.requests.ProfilRequest;
import com.jobinow.model.dto.responses.ProfilResponse;
import com.jobinow.model.entities.*;
import com.jobinow.model.mapper.ProfilMapper;
import com.jobinow.repositories.OfferRepository;
import com.jobinow.repositories.ProfilRepository;
import com.jobinow.services.spec.JobSeekerService;
import com.jobinow.services.spec.ProfileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Implementation of the {@link JobSeekerService} interface for job seeker-related operations.
 * This service provides methods for job seekers to apply to jobs, retrieve applied, saved, and recommended jobs,
 * and filter jobs based on various criteria such as profile, location, salary range, job title, and company.
 * <p>
 * The class leverages the specified repository ({@link OfferRepository}) for data access and handles
 * operations related to {@link Offer}, {@link Apply}, {@link User}, {@link Profil}, and {@link Company}.
 * </p>
 *
 * @version 1.0
 * @see JobSeekerService
 * @see Offer
 * @see Apply
 * @see User
 * @see Profil
 * @see Company
 * @see OfferRepository
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ProfileServiceImp extends _ServiceImp<UUID, ProfilRequest, ProfilResponse, Profil, ProfilRepository, ProfilMapper> implements ProfileService {
}