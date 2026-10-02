package com.backintro.infrastructure.chatescalationstatushistory.adapters.in.rest.dtos;

import java.util.UUID;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateChatEscalationStatusHistoryRequest(
        @jakarta.validation.constraints.NotNull(message = "escalationId is required")
        UUID escalationId,

        @jakarta.validation.constraints.NotNull(message = "escalationStatusId is required")
        UUID escalationStatusId,

        java.time.LocalDateTime changedAt
) {}