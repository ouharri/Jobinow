package com.jobinow.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * Entity class representing a chat message.
 *
 * <p>This class includes information about the chat message, such as its ID, sender, recipient, and content.</p>
 *
 * @version 1.0
 */
@Getter
@Setter
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ChatMessage extends AbstractEntity {
    /**
     * The unique identifier for the chat room associated with the message.
     */
    private String chatId;

    /**
     * The sender of the chat message.
     */
    @ManyToOne
    private User sender;

    /**
     * The recipient of the chat message.
     */
    @ManyToOne
    private User recipient;

    /**
     * The content of the chat message.
     */
    private String content;
}