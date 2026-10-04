package com.backintro.domain.chatescalation.event;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.chatescalation.model.valueobject.ChatEscalationId;

public record ChatEscalationUpdatedEvent(
    ChatEscalationId id,
    UUID conversationId,
    UUID statusId,
    Boolean fromAi,
    String reason,
    LocalDateTime occurredOn
) implements DomainEvent {

    public ChatEscalationUpdatedEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(conversationId, "conversationId must not be null");
        Objects.requireNonNull(statusId, "statusId must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}