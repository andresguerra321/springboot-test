package com.backintro.infrastructure.chatescalationassignment.adapters.in.rest.dtos;

import java.util.UUID;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UpdateChatEscalationAssignmentRequest(
        @jakarta.validation.constraints.NotNull(message = "escalationId is required")
        UUID escalationId,

        @jakarta.validation.constraints.NotNull(message = "professionalId is required")
        UUID professionalId,

        java.time.LocalDateTime assignedAt
) {}