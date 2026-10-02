package com.backintro.domain.chatescalationstatushistory.event;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.chatescalationstatushistory.model.valueobject.ChatEscalationStatusHistoryId;

public record ChatEscalationStatusHistoryUpdatedEvent(
    ChatEscalationStatusHistoryId id,
    UUID escalationId,
    UUID escalationStatusId,
    java.time.LocalDateTime changedAt,
    LocalDateTime occurredOn
) implements DomainEvent {

    public ChatEscalationStatusHistoryUpdatedEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(escalationId, "escalationId must not be null");
        Objects.requireNonNull(escalationStatusId, "escalationStatusId must not be null");
        Objects.requireNonNull(changedAt, "changedAt must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}