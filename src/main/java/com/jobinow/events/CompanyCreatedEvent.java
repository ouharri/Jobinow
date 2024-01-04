package com.jobinow.events;

import org.springframework.context.ApplicationEvent;

/**
 * Event class representing the creation of a Company activity.
 */
public class CompanyCreatedEvent extends ApplicationEvent {

    /**
     * Constructs a new CompanyCreatedEvent.
     *
     * @param source The source of the event.
     */
    public CompanyCreatedEvent(Object source) {
        super(source);
    }

}