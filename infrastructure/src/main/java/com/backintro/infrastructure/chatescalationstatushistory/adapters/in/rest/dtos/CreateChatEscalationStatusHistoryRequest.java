package com.backintro.infrastructure.chatescalationstatushistory.adapters.in.rest.dtos;

import java.util.UUID;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CreateChatEscalationStatusHistoryRequest(
        @NotNull(message = "escalationId is required")
        UUID escalationId,

        @NotNull(message = "escalationStatusId is required")
        UUID escalationStatusId,

        @NotNull(message = "changedAt is required")


        java.time.LocalDateTime changedAt
) {}