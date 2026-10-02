package com.backintro.application.chatescalationassignment.command;

import java.util.Objects;
import java.util.UUID;

public record RegisterChatEscalationAssignmentCommand(
        UUID escalationId,
        UUID professionalId,
        java.time.LocalDateTime assignedAt
) {
    public RegisterChatEscalationAssignmentCommand {
        Objects.requireNonNull(escalationId, "escalationId must not be null");
        Objects.requireNonNull(professionalId, "professionalId must not be null");
        Objects.requireNonNull(assignedAt, "assignedAt must not be null");
    }
}