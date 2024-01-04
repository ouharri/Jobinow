package com.jobinow.services.spec;

/**
 * Service interface for handling SMS (Short Message Service) functionality in the system.
 * This interface defines methods for sending and managing SMS messages.
 */
public interface SmsService {

    /**
     * Send an SMS message to the specified phone number.
     *
     * @param phoneNumber The recipient's phone number.
     * @param message     The content of the SMS message.
     * @return A status or response indicating the result of the SMS sending operation.
     */
    String sendSms(String phoneNumber, String message);

    /**
     * Receive and process incoming SMS messages.
     *
     * @return A response or acknowledgment related to the processing of incoming SMS messages.
     */
    String receiveAndProcessSms();

    /**
     * Check the delivery status of a scent SMS message.
     *
     * @param messageId The unique identifier of the scent SMS message.
     * @return The delivery status of the SMS message (e.g., delivered, pending).
     */
    String checkSmsDeliveryStatus(String messageId);

}