package com.backintro.domain.chatairunmetric.event;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.chatairunmetric.model.valueobject.ChatAiRunMetricId;

public record ChatAiRunMetricUpdatedEvent(
    ChatAiRunMetricId id,
    UUID aiRunId,
    Integer promptTokens,
    Integer completionTokens,
    Integer totalTokens,
    java.math.BigDecimal cost,
    LocalDateTime occurredOn
) implements DomainEvent {

    public ChatAiRunMetricUpdatedEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(aiRunId, "aiRunId must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}