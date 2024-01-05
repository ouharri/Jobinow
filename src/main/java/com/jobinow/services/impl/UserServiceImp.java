package com.jobinow.services.impl;

import com.jobinow.model.dto.requests.ChangePasswordRequest;
import com.jobinow.model.dto.responses.UserResponses;
import com.jobinow.model.entities.User;
import com.jobinow.model.enums.Role;
import com.jobinow.model.enums.UserStatus;
import com.jobinow.model.mapper.UserMapper;
import com.jobinow.repositories.UserRepository;
import com.jobinow.services.spec.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.security.Principal;
import java.util.Optional;
import java.util.UUID;

/**
 * Service class for managing user-related operations.
 *
 * <p>This service class provides methods for retrieving user data based on various criteria,
 * updating user information, and handling user status changes.</p>
 *
 * @author Ouharri Outman
 * @version 1.0
 */
@Slf4j
@Service
@Validated
@RequiredArgsConstructor
public class UserServiceImp implements UserService {
    private final UserRepository repository;
    private final UserMapper mapper;
    private final PasswordEncoder passwordEncoder;

    /**
     * Retrieves a paginated list of all users.
     *
     * @param pageable The pagination information.
     * @return A paginated list of all users.
     */
    public Page<UserResponses> getAllUsers(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toResponse);
    }

    /**
     * Retrieves a paginated list of manager users.
     *
     * @param pageable The pagination information.
     * @return A paginated list of manager users.
     */
    public Page<UserResponses> getAllManager(Pageable pageable) {
        return repository.findAllByRole(Role.MANAGER, pageable)
                .map(mapper::toResponse);
    }

    /**
     * Retrieves a paginated list of agent users.
     *
     * @param pageable The pagination information.
     * @return A paginated list of agent users.
     */
    public Page<UserResponses> getAllAgent(Pageable pageable) {
        return repository.findAllByRole(Role.AGENT, pageable)
                .map(mapper::toResponse);
    }

    /**
     * Retrieves a paginated list of job seeker users.
     *
     * @param pageable The pagination information.
     * @return A paginated list of job seeker users.
     */
    public Page<UserResponses> getAllJobSeeker(Pageable pageable) {
        return repository.findAllByRole(Role.JOB_SEEKER, pageable)
                .map(mapper::toResponse);
    }

    /**
     * Retrieves a user by email.
     *
     * @param email The email of the user to retrieve.
     * @return Optional containing the user if found, otherwise empty.
     */
    public Optional<User> findByEmail(String email) {
        return repository.findByEmail(email);
    }

    /**
     * Retrieves a user by ID.
     *
     * @param username The ID of the user to retrieve.
     * @return Optional containing the user if found, otherwise empty.
     */
    public Optional<User> findById(UUID username) {
        return repository.findById(username);
    }

    /**
     * Changes the password of the currently logged-in user.
     *
     * @param request       The change password request.
     * @param connectedUser The principal representing the currently connected user.
     * @throws IllegalStateException If the current password is incorrect, or if the new passwords do not match.
     */
    public void changePassword(ChangePasswordRequest request, Principal connectedUser) {
        var user = (User) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();

        if (!passwordEncoder.matches(request.currentPassword(), user.getPassword())) {
            throw new IllegalStateException("Wrong password");
        }

        if (!request.newPassword().equals(request.confirmationPassword())) {
            throw new IllegalStateException("Passwords are not the same");
        }

        user.setPassword(passwordEncoder.encode(request.newPassword()));

        repository.save(user);
    }

    /**
     * Updates the status of the specified user to offline.
     *
     * @param user The user to update.
     */
    public void disconnect(User user) {
        var storedUser = repository.findById(user.getId()).orElse(null);
        if (storedUser != null) {
            storedUser.setStatus(UserStatus.OFFLINE);
            repository.save(storedUser);
        }
    }

    /**
     * Retrieves a paginated list of connected users.
     *
     * @param pageable The pagination information.
     * @return A paginated list of connected users.
     */
    public Page<UserResponses> findConnectedUsers(Pageable pageable) {
        return repository.findAllByStatus(UserStatus.ONLINE, pageable).map(mapper::toResponse);
    }
}