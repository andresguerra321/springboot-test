package com.backintro.domain.chatairunerror.event;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.chatairunerror.model.valueobject.ChatAiRunErrorId;

public record ChatAiRunErrorUpdatedEvent(
    ChatAiRunErrorId id,
    UUID aiRunId,
    String errorMessage,
    String errorCode,
    String providerErrorId,
    LocalDateTime occurredOn
) implements DomainEvent {

    public ChatAiRunErrorUpdatedEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(aiRunId, "aiRunId must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}