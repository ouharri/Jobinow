package com.jobinow.controllers;

import com.jobinow.model.dto.responses.UserResponses;
import com.jobinow.services.spec.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class handling user-related endpoints.
 *
 * <p>This class provides RESTful endpoints for retrieving different categories of users (managers, job-seekers, and agents).
 * It utilizes the {@link UserService} to fetch user data and returns the results in the form of {@link UserResponses}.
 * </p>
 *
 * @version 1.0
 */
@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v2/user")
public class UserController {
    private final UserService service;

    /**
     * Retrieves a paginated list of managers.
     *
     * @param pageable The pagination information.
     * @return ResponseEntity containing a paginated list of manager users.
     */
    @GetMapping("/managers")
    public ResponseEntity<Page<UserResponses>> getManagers(Pageable pageable) {
        return ResponseEntity.ok(service.getAllManager(pageable));
    }

    /**
     * Retrieves a paginated list of job-seekers.
     *
     * @param pageable The pagination information.
     * @return ResponseEntity containing a paginated list of job-seeker users.
     */
    @GetMapping("/job-seekers")
    public ResponseEntity<Page<UserResponses>> getJobSeekers(Pageable pageable) {
        return ResponseEntity.ok(service.getAllJobSeeker(pageable));
    }

    /**
     * Retrieves a paginated list of agents.
     *
     * @param pageable The pagination information.
     * @return ResponseEntity containing a paginated list of agent users.
     */
    @GetMapping("/agents")
    public ResponseEntity<Page<UserResponses>> getAgents(Pageable pageable) {
        return ResponseEntity.ok(service.getAllAgent(pageable));
    }
}