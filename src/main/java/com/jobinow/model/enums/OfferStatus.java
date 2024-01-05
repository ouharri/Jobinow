package com.jobinow.model.enums;

/**
 * Enumeration representing the status of a job offer.
 * Possible statuses include ACCEPTED, DENIED, and PENDING.
 * This enum is used to indicate the current status of a job offer in the system.
 *
 * @author <a href="mailto:ouharri.outman@gmail.com">ouharri</a>
 * @version 1.0
 */
public enum OfferStatus {
    /**
     * The job offer has been accepted.
     */
    ACCEPTED,

    /**
     * The job offer has been denied.
     */
    DENIED,

    /**
     * The job offer is pending and has not been processed yet.
     */
    PENDING
}