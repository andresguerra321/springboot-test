package com.backintro.application.citymunicipality.command;

import java.util.Objects;
import java.util.UUID;

public record RegisterCityMunicipalityCommand(
        String code,
        String name,
        String description,
        UUID regionId
) {
    public RegisterCityMunicipalityCommand {
        Objects.requireNonNull(name, "name must not be null");
        Objects.requireNonNull(regionId, "regionId must not be null");
    }
}