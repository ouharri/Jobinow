package com.jobinow.model.enums;

/**
 * Enumeration representing different types of application methods.
 * Applications can be submitted through various channels, and this enum
 * defines the possible types of application methods.
 *
 * @version 1.0
 */
public enum ApplyType {
    /**
     * Apply online through a web-based application form.
     */
    ONLINE,

    /**
     * Submit an offline application, such as a physical form or document.
     */
    OFFLINE,

    /**
     * Apply via email by sending application materials to a specified email address.
     */
    EMAIL,

    /**
     * Apply in person by submitting application materials directly at a physical location.
     */
    IN_PERSON,
}