package com.backintro.domain.chatairun.event;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.chatairun.model.valueobject.ChatAiRunId;

public record ChatAiRunUpdatedEvent(
    ChatAiRunId id,
    UUID conversationId,
    UUID messageId,
    UUID modelId,
    UUID aiRunStatusId,
    LocalDateTime occurredOn
) implements DomainEvent {

    public ChatAiRunUpdatedEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(conversationId, "conversationId must not be null");
        Objects.requireNonNull(messageId, "messageId must not be null");
        Objects.requireNonNull(modelId, "modelId must not be null");
        Objects.requireNonNull(aiRunStatusId, "aiRunStatusId must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}