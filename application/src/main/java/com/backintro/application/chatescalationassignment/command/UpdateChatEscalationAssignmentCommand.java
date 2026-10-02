package com.backintro.application.chatescalationassignment.command;

import java.util.Objects;
import java.util.UUID;

import com.backintro.domain.chatescalationassignment.model.valueobject.ChatEscalationAssignmentId;

public record UpdateChatEscalationAssignmentCommand(
        ChatEscalationAssignmentId id,
        UUID escalationId,
        UUID professionalId,
        java.time.LocalDateTime assignedAt
) {
    public UpdateChatEscalationAssignmentCommand {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(escalationId, "escalationId must not be null");
        Objects.requireNonNull(professionalId, "professionalId must not be null");
        Objects.requireNonNull(assignedAt, "assignedAt must not be null");
    }
}