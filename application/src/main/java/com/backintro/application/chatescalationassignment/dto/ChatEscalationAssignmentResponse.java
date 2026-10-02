package com.backintro.application.chatescalationassignment.dto;

import java.util.UUID;
import java.time.LocalDateTime;

public record ChatEscalationAssignmentResponse(
        UUID id,
        UUID escalationId,
        UUID professionalId,
        String professionalName,
        java.time.LocalDateTime assignedAt
) {
}