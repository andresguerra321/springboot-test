package com.backintro.application.stateregion.command;

import java.util.Objects;
import java.util.UUID;

import com.backintro.domain.stateregion.model.valueobject.StateRegionId;

public record UpdateStateRegionCommand(
        StateRegionId id,
        String code,
        String name,
        String description,
        UUID countryId
) {
    public UpdateStateRegionCommand {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(name, "name must not be null");
        Objects.requireNonNull(countryId, "countryId must not be null");
    }
}