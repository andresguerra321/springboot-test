package com.backintro.domain.aimodel.event;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.aimodel.model.valueobject.AiModelId;

public record AiModelUpdatedEvent(
    AiModelId id,
    UUID providerModelId,
    String nameModel,
    String modelKey,
    java.math.BigDecimal inputTokenPrice,
    java.math.BigDecimal outputTokenPrice,
    Integer maxTokens,
    Integer contextWindow,
    LocalDateTime occurredOn
) implements DomainEvent {

    public AiModelUpdatedEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(providerModelId, "providerModelId must not be null");
        Objects.requireNonNull(nameModel, "nameModel must not be null");
        Objects.requireNonNull(modelKey, "modelKey must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}