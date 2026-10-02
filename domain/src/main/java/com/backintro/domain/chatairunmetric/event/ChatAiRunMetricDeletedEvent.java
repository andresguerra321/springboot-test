package com.backintro.domain.chatairunmetric.event;

import java.time.LocalDateTime;
import java.util.Objects;

import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.chatairunmetric.model.valueobject.ChatAiRunMetricId;

public record ChatAiRunMetricDeletedEvent(
    ChatAiRunMetricId id,
    LocalDateTime occurredOn
) implements DomainEvent {

    public ChatAiRunMetricDeletedEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}