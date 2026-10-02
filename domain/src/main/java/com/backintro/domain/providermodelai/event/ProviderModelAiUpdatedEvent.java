package com.backintro.domain.providermodelai.event;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.providermodelai.model.valueobject.ProviderModelAiId;

public record ProviderModelAiUpdatedEvent(
    ProviderModelAiId id,
    String nameProviderAi,
    String razonSocial,
    String sitioWeb,
    LocalDateTime occurredOn
) implements DomainEvent {

    public ProviderModelAiUpdatedEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(nameProviderAi, "nameProviderAi must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}