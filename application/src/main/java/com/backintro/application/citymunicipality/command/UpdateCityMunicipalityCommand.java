package com.backintro.application.citymunicipality.command;

import java.util.Objects;
import java.util.UUID;

import com.backintro.domain.citymunicipality.model.valueobject.CityMunicipalityId;

public record UpdateCityMunicipalityCommand(
        CityMunicipalityId id,
        String code,
        String name,
        String description,
        UUID regionId
) {
    public UpdateCityMunicipalityCommand {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(name, "name must not be null");
        Objects.requireNonNull(regionId, "regionId must not be null");
    }
}