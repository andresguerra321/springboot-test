package com.backintro.application.chatmessage.dto;

import java.util.UUID;
import java.time.LocalDateTime;

public record ChatMessageResponse(
        UUID id,
        UUID conversationId,
        UUID messageTypeId,
        String messageTypeName,
        UUID participantId,
        String content,
        String metadata,
        LocalDateTime createdAt
) {
}