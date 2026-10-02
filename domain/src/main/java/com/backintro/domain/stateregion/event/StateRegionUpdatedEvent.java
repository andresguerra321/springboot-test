package com.backintro.domain.stateregion.event;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.stateregion.model.valueobject.StateRegionId;

public record StateRegionUpdatedEvent(
    StateRegionId id,
    String code,
    String name,
    String description,
    UUID countryId,
    LocalDateTime occurredOn
) implements DomainEvent {

    public StateRegionUpdatedEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(name, "name must not be null");
        Objects.requireNonNull(countryId, "countryId must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}