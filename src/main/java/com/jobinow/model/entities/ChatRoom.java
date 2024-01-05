package com.jobinow.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * Entity class representing a chat room.
 *
 * <p>This class includes information about the chat room, such as its ID, sender, and recipient.</p>
 *
 * @version 1.0
 */
@Getter
@Setter
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ChatRoom extends AbstractEntity {
    /**
     * The unique identifier for the chat room.
     */
    private String chatId;

    /**
     * The sender of the chat room.
     */
    @OneToOne
    private User sender;

    /**
     * The recipient of the chat room.
     */
    @OneToOne
    private User recipient;
}