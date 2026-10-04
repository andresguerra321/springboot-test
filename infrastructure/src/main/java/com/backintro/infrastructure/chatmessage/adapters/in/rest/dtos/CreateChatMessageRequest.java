package com.backintro.infrastructure.chatmessage.adapters.in.rest.dtos;

import java.util.UUID;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CreateChatMessageRequest(
        @NotNull(message = "conversationId is required")
        UUID conversationId,

        @NotNull(message = "messageTypeId is required")
        UUID messageTypeId,

        @NotNull(message = "participantId is required")
        UUID participantId,

        String content,

        String metadata
) {}