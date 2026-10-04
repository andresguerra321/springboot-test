package com.backintro.infrastructure.chatconversation.adapters.in.rest.dtos;

import java.util.UUID;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CreateChatConversationRequest(
        @NotNull(message = "conversationStatusId is required")
        UUID conversationStatusId,

        @NotNull(message = "priorityId is required")
        UUID priorityId,

        java.time.LocalDateTime lastMessageAt,

        Boolean closed,

        java.time.LocalDateTime closedAt,

        UUID closedBy
) {}