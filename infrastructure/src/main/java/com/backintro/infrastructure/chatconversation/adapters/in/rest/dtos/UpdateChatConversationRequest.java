package com.backintro.infrastructure.chatconversation.adapters.in.rest.dtos;

import java.util.UUID;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UpdateChatConversationRequest(
        @jakarta.validation.constraints.NotNull(message = "conversationStatusId is required")
        UUID conversationStatusId,

        @jakarta.validation.constraints.NotNull(message = "priorityId is required")
        UUID priorityId,

        java.time.LocalDateTime lastMessageAt,

        boolean closed,

        java.time.LocalDateTime closedAt,

        UUID closedBy
) {}