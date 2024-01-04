package com.jobinow.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Enumeration representing different roles in the system.
 * Each role is associated with a set of permissions, defining the level of access for users with that role.
 * This enum provides a convenient way to manage and assign roles and permissions throughout the application.
 *
 * @author <a href="mailto:ouharri.outman@gmail.com">ouharri</a>
 * @version 1.0
 */
@Getter
@RequiredArgsConstructor
public enum Role {

    /**
     * Basic user role with minimal permissions.
     */
    USER(Collections.emptySet()),

    /**
     * Role for recruiters with specific permissions for reading, creating, updating,
     * and deleting recruiter-related information.
     */
    RECRUITER(
            Set.of(
                    Permission.RECRUITER_READ,
                    Permission.RECRUITER_CREATE,
                    Permission.RECRUITER_UPDATE,
                    Permission.RECRUITER_DELETE
            )
    ),

    /**
     * F
     * Role for managers with specific permissions for reading, creating, updating,
     * and deleting manager-related information.
     */
    MANAGER(
            Set.of(
                    Permission.MANAGER_READ,
                    Permission.MANAGER_UPDATE,
                    Permission.MANAGER_DELETE,
                    Permission.MANAGER_CREATE
            )
    ),

    /**
     * F
     * Role for managers (agent) with specific permissions for reading, creating, updating,
     * and deleting manager-related information.
     */
    AGENT(
            Set.of(
                    Permission.AGENT_READ,
                    Permission.AGENT_UPDATE,
                    Permission.AGENT_DELETE,
                    Permission.AGENT_CREATE
            )
    ),

    /**
     * Role for job seeker with specific permissions for reading, creating, updating,
     * and deleting manager-related information.
     */
    JOB_SEEKER(
            Set.of(
                    Permission.JOB_SEEKER_READ,
                    Permission.JOB_SEEKER_UPDATE,
                    Permission.JOB_SEEKER_DELETE,
                    Permission.JOB_SEEKER_CREATE
            )
    ),

    /**
     * Role for super_administrators with extensive permissions across recruiter,
     * manager, and super_administrator activities.
     */
    SUPER_ADMINISTRATOR(
            Set.of(
                    Permission.RECRUITER_READ,
                    Permission.RECRUITER_CREATE,
                    Permission.RECRUITER_UPDATE,
                    Permission.RECRUITER_DELETE,
                    Permission.MANAGER_READ,
                    Permission.MANAGER_UPDATE,
                    Permission.MANAGER_DELETE,
                    Permission.MANAGER_CREATE,
                    Permission.SUPER_ADMINISTRATOR_READ,
                    Permission.SUPER_ADMINISTRATOR_UPDATE,
                    Permission.SUPER_ADMINISTRATOR_DELETE,
                    Permission.SUPER_ADMINISTRATOR_CREATE
            )
    );

    private final Set<Permission> permissions;

    /**
     * Get the authorities associated with the role.
     *
     * @return List of authorities including the role and associated permissions.
     */
    public List<SimpleGrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        authorities.addAll(getPermissions()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .toList()
        );
        return authorities;
    }

}