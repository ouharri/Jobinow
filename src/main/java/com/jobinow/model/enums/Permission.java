package com.jobinow.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Enumeration representing different permissions in the system.
 * Each permission is associated with a specific role, such as recruiter, manager, or super_administrator.
 * This enum provides a convenient way to define and access permissions throughout the application.
 *
 * @author <a href="mailto:ouharri.outman@gmail.com">ouharri</a>
 * @version 1.0
 */
@Getter
@RequiredArgsConstructor
public enum Permission {

    /**
     * Permission for reading recruiter-related information.
     */
    RECRUITER_READ("admin:read"),

    /**
     * Permission for updating recruiter-related information.
     */
    RECRUITER_UPDATE("admin:update"),

    /**
     * Permission for creating new recruiter-related information.
     */
    RECRUITER_CREATE("admin:create"),

    /**
     * Permission for deleting recruiter-related information.
     */
    RECRUITER_DELETE("admin:delete"),

    /**
     * Permission for reading manager-related information.
     */
    MANAGER_READ("management:read"),

    /**
     * Permission for updating manager-related information.
     */
    MANAGER_UPDATE("management:update"),

    /**
     * Permission for creating new manager-related information.
     */
    MANAGER_CREATE("management:create"),

    /**
     * Permission for deleting manager-related information.
     */
    MANAGER_DELETE("management:delete"),

    AGENT_READ("agent:read"),

    /**
     * Permission for updating manager-related information.
     */
    AGENT_UPDATE("agent:update"),

    /**
     * Permission for creating new manager-related information.
     */
    AGENT_CREATE("agent:create"),

    /**
     * Permission for deleting manager-related information.
     */
    AGENT_DELETE("agent:delete"),

    JOB_SEEKER_READ("agent:read"),

    /**
     * Permission for updating manager-related information.
     */
    JOB_SEEKER_UPDATE("agent:update"),

    /**
     * Permission for creating new manager-related information.
     */
    JOB_SEEKER_CREATE("agent:create"),

    /**
     * Permission for deleting manager-related information.
     */
    JOB_SEEKER_DELETE("agent:delete"),

    /**
     * Permission for reading super_administrator related information.
     */
    SUPER_ADMINISTRATOR_READ("admin:read"),

    /**
     * Permission for updating super_administrator related information.
     */
    SUPER_ADMINISTRATOR_UPDATE("admin:update"),

    /**
     * Permission for creating new super_administrator related information.
     */
    SUPER_ADMINISTRATOR_CREATE("admin:create"),

    /**
     * Permission for deleting super_administrator related information.
     */
    SUPER_ADMINISTRATOR_DELETE("admin:delete");

    private final String permission;
}