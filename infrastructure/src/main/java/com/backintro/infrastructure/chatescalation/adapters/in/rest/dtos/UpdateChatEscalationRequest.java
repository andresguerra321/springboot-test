package com.backintro.infrastructure.chatescalation.adapters.in.rest.dtos;

import java.util.UUID;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UpdateChatEscalationRequest(
        @NotNull(message = "conversationId is required")
        UUID conversationId,

        @NotNull(message = "statusId is required")
        UUID statusId,

        Boolean fromAi,

        String reason
) {}