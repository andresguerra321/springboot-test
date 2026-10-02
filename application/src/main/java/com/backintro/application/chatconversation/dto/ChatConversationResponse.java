package com.backintro.application.chatconversation.dto;

import java.util.UUID;
import java.time.LocalDateTime;

public record ChatConversationResponse(
        UUID id,
        UUID conversationStatusId,
        String conversationStatusName,
        UUID priorityId,
        String priorityName,
        java.time.LocalDateTime lastMessageAt,
        boolean closed,
        java.time.LocalDateTime closedAt,
        UUID closedBy,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}