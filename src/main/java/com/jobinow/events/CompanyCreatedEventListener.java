package com.jobinow.events;

import com.jobinow.model.entities.VerificationCode;
import com.jobinow.services.spec.EmailService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Event listener for handling events related to hunting activities.
 */
@Slf4j
@Component
@AllArgsConstructor
public class CompanyCreatedEventListener {

    private final EmailService emailService;

    /**
     * Handles the event when a hunting activity is created.
     *
     * @param event The CompanyCreatedEvent.
     */
    @EventListener
    public void handleHuntingCreatedEvent(CompanyCreatedEvent event) {
        if (event.getSource() instanceof VerificationCode verificationCode) {
            log.info("Company created event received for VerificationCode with id: {}", verificationCode.getId());
            emailService.sendSimpleMessageAsync(
                    verificationCode.getCompany().getEmail(),
                    "Company Verification Code",
                    "Your Company creating Verification Code is: " + verificationCode.getCode()
            );
        }
    }
}
