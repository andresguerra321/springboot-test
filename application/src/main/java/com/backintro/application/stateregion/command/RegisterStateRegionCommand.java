package com.backintro.application.stateregion.command;

import java.util.Objects;
import java.util.UUID;

public record RegisterStateRegionCommand(
        String code,
        String name,
        String description,
        UUID countryId
) {
    public RegisterStateRegionCommand {
        Objects.requireNonNull(name, "name must not be null");
        Objects.requireNonNull(countryId, "countryId must not be null");
    }
}