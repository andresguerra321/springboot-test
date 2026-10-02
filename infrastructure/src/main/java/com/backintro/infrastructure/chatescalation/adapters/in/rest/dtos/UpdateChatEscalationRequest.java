package com.backintro.infrastructure.chatescalation.adapters.in.rest.dtos;

import java.util.UUID;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UpdateChatEscalationRequest(
        @jakarta.validation.constraints.NotNull(message = "conversationId is required")
        UUID conversationId,

        @jakarta.validation.constraints.NotNull(message = "statusId is required")
        UUID statusId,

        boolean fromAi,

        String reason
) {}