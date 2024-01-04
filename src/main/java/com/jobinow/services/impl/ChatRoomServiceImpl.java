package com.jobinow.services.impl;

import com.jobinow.model.entities.ChatRoom;
import com.jobinow.repositories.ChatRoomRepository;
import com.jobinow.services.spec.ChatRoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service implementation for managing chat rooms.
 *
 * <p>This service provides methods for getting chat room IDs based on sender and recipient IDs.
 * It can also create a new chat room if it does not exist.</p>
 *
 * @version 1.0
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ChatRoomServiceImpl implements ChatRoomService {
    private final ChatRoomRepository chatRoomRepository;

    /**
     * Gets the chat room ID for the given sender and recipient IDs.
     *
     * @param senderId                The ID of the sender.
     * @param recipientId             The ID of the recipient.
     * @param createNewRoomIfNotExists If true, creates a new chat room if it does not exist.
     * @return An optional containing the chat room ID, or empty if not found or creation is disabled.
     */
    public Optional<String> getChatRoomId(
            String senderId,
            String recipientId,
            boolean createNewRoomIfNotExists
    ) {
        return chatRoomRepository
                .findBySenderIdAndRecipientId(senderId, recipientId)
                .map(ChatRoom::getChatId)
                .or(() -> {
                    if (createNewRoomIfNotExists) {
                        var chatId = createChatId(senderId, recipientId);
                        return Optional.of(chatId);
                    }

                    return Optional.empty();
                });
    }

    private String createChatId(String senderId, String recipientId) {
        var chatId = String.format("%s_%s", senderId, recipientId);

        ChatRoom senderRecipient = ChatRoom
                .builder()
                .chatId(chatId)
                .senderId(senderId)
                .recipientId(recipientId)
                .build();

        ChatRoom recipientSender = ChatRoom
                .builder()
                .chatId(chatId)
                .senderId(recipientId)
                .recipientId(senderId)
                .build();

        chatRoomRepository.save(senderRecipient);
        chatRoomRepository.save(recipientSender);

        return chatId;
    }
}