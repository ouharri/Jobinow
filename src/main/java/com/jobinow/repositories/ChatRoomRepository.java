package com.jobinow.repositories;

import com.jobinow.model.entities.ChatRoom;
import com.jobinow.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for accessing and managing {@link ChatRoom} entities in the database.
 *
 * <p>This repository provides methods to interact with chat room entities, such as finding a chat room
 * by sender and recipient IDs.</p>
 *
 * @version 1.0
 */
public interface ChatRoomRepository extends JpaRepository<ChatRoom, UUID> {

    /**
     * Finds a chat room by the IDs of the sender and recipient.
     *
     * @param senderId    The ID of the sender.
     * @param recipientId The ID of the recipient.
     * @return An optional containing the chat room, or empty if not found.
     */
    Optional<ChatRoom> findBySenderAndRecipient(User sender, User recipient);

    /**
     * Finds chat messages by the specified chat ID.
     *
     * @param chatId The chat ID to find messages for.
     * @return A list of chat messages for the given chat ID.
     */
    Optional<ChatRoom> findBySender_IdAndRecipient_Id(UUID senderId, UUID recipientId);
}