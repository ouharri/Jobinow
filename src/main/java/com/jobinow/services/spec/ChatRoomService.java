package com.jobinow.services.spec;

import java.util.Optional;

/**
 * Service interface for managing chat rooms between users.
 *
 * <p>This interface provides methods to get a chat room ID based on sender and recipient IDs.
 * It also allows creating a new chat room if it does not exist.</p>
 *
 * @version 1.0
 */
public interface ChatRoomService {

    /**
     * Gets the chat room ID based on sender and recipient IDs.
     *
     * @param senderId               The ID of the sender user.
     * @param recipientId            The ID of the recipient user.
     * @param createNewRoomIfNotExists If true, creates a new room if it does not exist.
     * @return An optional containing the chat room ID if it exists.
     */
    Optional<String> getChatRoomId(
            String senderId,
            String recipientId,
            boolean createNewRoomIfNotExists
    );

}