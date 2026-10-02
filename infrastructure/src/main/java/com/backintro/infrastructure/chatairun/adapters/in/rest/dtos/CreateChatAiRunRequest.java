package com.backintro.infrastructure.chatairun.adapters.in.rest.dtos;

import java.util.UUID;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateChatAiRunRequest(
        @jakarta.validation.constraints.NotNull(message = "conversationId is required")
        UUID conversationId,

        @jakarta.validation.constraints.NotNull(message = "messageId is required")
        UUID messageId,

        @jakarta.validation.constraints.NotNull(message = "modelId is required")
        UUID modelId,

        @jakarta.validation.constraints.NotNull(message = "aiRunStatusId is required")
        UUID aiRunStatusId
) {}