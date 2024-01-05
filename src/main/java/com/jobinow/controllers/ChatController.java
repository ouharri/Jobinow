package com.jobinow.controllers;

import com.jobinow.model.dto.basic.ChatNotification;
import com.jobinow.model.entities.ChatMessage;
import com.jobinow.services.spec.ChatMessageService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * Controller class for handling chat-related operations.
 * This class includes methods for processing chat messages and finding chat messages between users.
 *
 * @version 1.0
 */
@Slf4j
@Validated
@Controller
@RestController
@AllArgsConstructor
@RequestMapping("api/v2/Chat")
public class ChatController {

    private final SimpMessagingTemplate messagingTemplate;
    private final ChatMessageService chatMessageService;

    /**
     * Processes incoming chat messages.
     *
     * @param chatMessage The incoming chat message payload.
     */
    @MessageMapping("/chat")
    public void processMessage(@Payload ChatMessage chatMessage) {
        ChatMessage savedMsg = chatMessageService.save(chatMessage);
        messagingTemplate.convertAndSendToUser(
                chatMessage.getRecipient()
                        .getId()
                        .toString(),
                "/queue/messages",
                new ChatNotification(
                        savedMsg.getId(),
                        savedMsg.getSender(),
                        savedMsg.getRecipient(),
                        savedMsg.getContent()
                )
        );
    }

    /**
     * Retrieves chat messages between two users.
     *
     * @param senderId    The ID of the sender.
     * @param recipientId The ID of the recipient.
     * @return A ResponseEntity containing a list of chat messages.
     */
    @GetMapping("/messages/{senderId}/{recipientId}")
    public ResponseEntity<List<ChatMessage>> findChatMessages(
            @PathVariable UUID senderId,
            @PathVariable UUID recipientId
    ) {
        return ResponseEntity
                .ok(chatMessageService.findChatMessages(senderId, recipientId));
    }
}