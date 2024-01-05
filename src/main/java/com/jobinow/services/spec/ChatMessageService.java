package com.jobinow.services.spec;

import com.jobinow.model.entities.ChatMessage;

import java.util.List;
import java.util.UUID;

/**
 * Service interface for managing chat messages.
 *
 * <p>This service provides methods for saving chat messages and retrieving chat messages
 * between specific sender and recipient.</p>
 *
 * @version 1.0
 */
public interface ChatMessageService {

    /**
     * Saves a chat message to the database.
     *
     * @param chatMessage The chat message to be saved.
     * @return The saved chat message.
     */
    ChatMessage save(ChatMessage chatMessage);

    /**
     * Finds chat messages between the specified sender and recipient.
     *
     * @param senderId    The ID of the sender.
     * @param recipientId The ID of the recipient.
     * @return A list of chat messages between the sender and recipient.
     */
    List<ChatMessage> findChatMessages(UUID senderId, UUID recipientId);
}