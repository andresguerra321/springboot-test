package com.backintro.domain.country.event;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.country.model.valueobject.CountryId;

public record CountryUpdatedEvent(
    CountryId id,
    String code,
    String name,
    String description,
    String telephonePrefix,
    LocalDateTime occurredOn
) implements DomainEvent {

    public CountryUpdatedEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(name, "name must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}