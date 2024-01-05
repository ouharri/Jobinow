package com.jobinow.services.impl;

import com.jobinow.model.entities.ChatRoom;
import com.jobinow.model.entities.User;
import com.jobinow.repositories.ChatRoomRepository;
import com.jobinow.services.spec.ChatRoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

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
     * @param sender                   The ID of the sender.
     * @param recipient                The ID of the recipient.
     * @param createNewRoomIfNotExists If true, creates a new chat room if it does not exist.
     * @return An optional containing the chat room ID, or empty if not found or creation is disabled.
     */
    public Optional<String> getChatRoomId(
            User sender,
            User recipient,
            boolean createNewRoomIfNotExists
    ) {
        return chatRoomRepository
                .findBySenderAndRecipient(sender, recipient)
                .map(ChatRoom::getChatId)
                .or(() -> {
                    if (createNewRoomIfNotExists) {
                        var chatId = createChatId(
                                sender,
                                recipient
                        );
                        return Optional.of(chatId);
                    }

                    return Optional.empty();
                });
    }

    public Optional<String> getChatRoomId(
            UUID sender,
            UUID recipient,
            boolean createNewRoomIfNotExists
    ) {
        return chatRoomRepository
                .findBySender_IdAndRecipient_Id(sender, recipient)
                .map(ChatRoom::getChatId)
                .or(() -> {
                    if (createNewRoomIfNotExists) {
                        var chatId = createChatId(
                                sender,
                                recipient
                        );
                        return Optional.of(chatId);
                    }

                    return Optional.empty();
                });
    }

    private String createChatId(User sender, User recipient) {
        var chatId = String.format(
                "%s_%s",
                sender.getId(),
                recipient.getId()
        );

        ChatRoom senderRecipient = ChatRoom
                .builder()
                .chatId(chatId)
                .sender(sender)
                .recipient(recipient)
                .build();

        ChatRoom recipientSender = ChatRoom
                .builder()
                .chatId(chatId)
                .sender(recipient)
                .recipient(sender)
                .build();

        chatRoomRepository.save(senderRecipient);
        chatRoomRepository.save(recipientSender);

        return chatId;
    }

    private String createChatId(UUID sender, UUID recipient) {
        var chatId = String.format(
                "%s_%s",
                sender.toString(),
                recipient.toString()
        );

        ChatRoom senderRecipient = ChatRoom
                .builder()
                .chatId(chatId)
                .sender(
                        User.builder()
                                .id(sender)
                                .build()
                )
                .recipient(
                        User.builder()
                                .id(recipient)
                                .build()
                )
                .build();

        ChatRoom recipientSender = ChatRoom
                .builder()
                .chatId(chatId)
                .sender(
                        User.builder()
                                .id(recipient)
                                .build()
                )
                .recipient(
                        User.builder()
                                .id(sender)
                                .build()
                )
                .build();

        chatRoomRepository.save(senderRecipient);
        chatRoomRepository.save(recipientSender);

        return chatId;
    }
}