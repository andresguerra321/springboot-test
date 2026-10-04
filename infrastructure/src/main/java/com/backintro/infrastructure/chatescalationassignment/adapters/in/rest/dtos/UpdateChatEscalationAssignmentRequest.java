package com.backintro.infrastructure.chatescalationassignment.adapters.in.rest.dtos;

import java.util.UUID;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UpdateChatEscalationAssignmentRequest(
        @NotNull(message = "escalationId is required")
        UUID escalationId,

        @NotNull(message = "professionalId is required")
        UUID professionalId,

        @NotNull(message = "assignedAt is required")


        java.time.LocalDateTime assignedAt
) {}