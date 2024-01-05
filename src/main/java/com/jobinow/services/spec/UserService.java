package com.jobinow.services.spec;

import com.jobinow.model.dto.requests.ChangePasswordRequest;
import com.jobinow.model.dto.responses.UserResponses;
import com.jobinow.model.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.security.Principal;
import java.util.Optional;
import java.util.UUID;

/**
 * Service interface for managing User entities.
 */
public interface UserService {

    /**
     * Retrieves a user by their unique identifier.
     *
     * @param id The unique identifier of the user.
     * @return An Optional containing the user, or an empty Optional if not found.
     */
    Optional<User> findById(UUID id);

    /**
     * Retrieves a list of all users.
     *
     * @param pageable The pagination information.
     * @return A paginated list of all users.
     */
    Page<UserResponses> getAllUsers(Pageable pageable);

    /**
     * Retrieves a paginated list of all managers.
     *
     * @param pageable The pagination information.
     * @return A paginated list of all managers.
     */
    Page<UserResponses> getAllManager(Pageable pageable);

    /**
     * Retrieves a paginated list of all agents.
     *
     * @param pageable The pagination information.
     * @return A paginated list of all agents.
     */
    Page<UserResponses> getAllAgent(Pageable pageable);

    /**
     * Retrieves a paginated list of all jobseekers.
     *
     * @param pageable The pagination information.
     * @return A paginated list of all jobseekers.
     */
    Page<UserResponses> getAllJobSeeker(Pageable pageable);

    /**
     * Changes the password for the user identified by the connected user principal.
     *
     * @param request       The request containing the old and new passwords.
     * @param connectedUser The principal representing the connected user.
     */
    void changePassword(ChangePasswordRequest request, Principal connectedUser);
}