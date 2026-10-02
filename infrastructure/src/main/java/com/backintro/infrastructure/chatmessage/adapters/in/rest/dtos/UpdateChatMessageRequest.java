package com.backintro.infrastructure.chatmessage.adapters.in.rest.dtos;

import java.util.UUID;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UpdateChatMessageRequest(
        @jakarta.validation.constraints.NotNull(message = "conversationId is required")
        UUID conversationId,

        @jakarta.validation.constraints.NotNull(message = "messageTypeId is required")
        UUID messageTypeId,

        @jakarta.validation.constraints.NotNull(message = "participantId is required")
        UUID participantId,

        String content,

        String metadata
) {}