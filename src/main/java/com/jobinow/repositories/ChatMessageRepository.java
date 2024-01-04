package com.jobinow.repositories;

import com.jobinow.model.entities.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * Repository interface for accessing and managing {@link ChatMessage} entities in the database.
 *
 * <p>This repository provides methods to interact with chat message entities, such as finding
 * chat messages by chat ID.</p>
 *
 * @version 1.0
 */
@Repository
public interface ChatMessageRepository extends JpaRepository<ChatMessage, UUID> {

    /**
     * Finds chat messages by the chat ID.
     *
     * @param chatId The ID of the chat.
     * @return A list of chat messages associated with the given chat ID.
     */
    List<ChatMessage> findByChatId(String chatId);
}