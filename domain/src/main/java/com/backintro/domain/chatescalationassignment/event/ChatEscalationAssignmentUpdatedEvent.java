package com.backintro.domain.chatescalationassignment.event;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.chatescalationassignment.model.valueobject.ChatEscalationAssignmentId;

public record ChatEscalationAssignmentUpdatedEvent(
    ChatEscalationAssignmentId id,
    UUID escalationId,
    UUID professionalId,
    java.time.LocalDateTime assignedAt,
    LocalDateTime occurredOn
) implements DomainEvent {

    public ChatEscalationAssignmentUpdatedEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(escalationId, "escalationId must not be null");
        Objects.requireNonNull(professionalId, "professionalId must not be null");
        Objects.requireNonNull(assignedAt, "assignedAt must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}