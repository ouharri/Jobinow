package com.jobinow.repositories;

import com.jobinow.model.entities.User;
import com.jobinow.model.enums.Role;
import com.jobinow.model.enums.UserStatus;
import io.micrometer.common.lang.NonNullApi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for accessing and managing {@link User} entities in the database.
 *
 * <p>This repository provides methods to interact with user entities, such as finding users by
 * email or ID, and retrieving users based on their status.</p>
 *
 * @version 1.0
 */
@Repository
@NonNullApi
public interface UserRepository extends JpaRepository<User, UUID> {

    /**
     * Finds a user by their email address.
     *
     * @param email The email address of the user.
     * @return An optional containing the user, or empty if not found.
     */
    Optional<User> findByEmail(String email);

    /**
     * Finds a user by their ID.
     *
     * @param id The ID of the user.
     * @return An optional containing the user, or empty if not found.
     */
    Optional<User> findById(UUID id);

    /**
     * Finds all users with a specific status.
     *
     * @param status The status of the users to retrieve.
     * @return A list of users with the specified status.
     */
    List<User> findAllByStatus(UserStatus status);

    List<User> findAllByRole(Role status);
}