package com.jobinow.services.impl;

import com.jobinow.model.entities.ChatMessage;
import com.jobinow.repositories.ChatMessageRepository;
import com.jobinow.services.spec.ChatMessageService;
import com.jobinow.services.spec.ChatRoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Service implementation for managing chat messages.
 *
 * <p>This service provides methods for saving chat messages and retrieving chat messages
 * between two users.</p>
 *
 * @version 1.0
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ChatMessageServiceImpl implements ChatMessageService {
    private final ChatMessageRepository repository;
    private final ChatRoomService chatRoomService;

    /**
     * Saves a chat message and associates it with the corresponding chat room.
     *
     * @param chatMessage The chat message to save.
     * @return The saved chat message.
     */
    public ChatMessage save(ChatMessage chatMessage) {
        var chatId = chatRoomService
                .getChatRoomId(
                        chatMessage.getSender(),
                        chatMessage.getRecipient(),
                        true
                )
                .orElseThrow();

        chatMessage.setChatId(chatId);
        repository.save(chatMessage);
        return chatMessage;
    }

    /**
     * Finds chat messages between two users based on their sender and recipient IDs.
     *
     * @param senderId    The ID of the sender.
     * @param recipientId The ID of the recipient.
     * @return A list of chat messages between the specified users.
     */
    public List<ChatMessage> findChatMessages(UUID senderId, UUID recipientId) {
        var chatId = chatRoomService.getChatRoomId(
                senderId,
                recipientId,
                false
        );
        return chatId.map(repository::findByChatId).orElse(new ArrayList<>());
    }
}