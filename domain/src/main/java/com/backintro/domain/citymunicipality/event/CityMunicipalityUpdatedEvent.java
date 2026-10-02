package com.backintro.domain.citymunicipality.event;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.citymunicipality.model.valueobject.CityMunicipalityId;

public record CityMunicipalityUpdatedEvent(
    CityMunicipalityId id,
    String code,
    String name,
    String description,
    UUID regionId,
    LocalDateTime occurredOn
) implements DomainEvent {

    public CityMunicipalityUpdatedEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(name, "name must not be null");
        Objects.requireNonNull(regionId, "regionId must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}