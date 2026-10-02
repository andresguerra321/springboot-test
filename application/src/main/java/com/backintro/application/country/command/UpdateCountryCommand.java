package com.backintro.application.country.command;

import java.util.Objects;
import java.util.UUID;

import com.backintro.domain.country.model.valueobject.CountryId;

public record UpdateCountryCommand(
        CountryId id,
        String code,
        String name,
        String description,
        String telephonePrefix
) {
    public UpdateCountryCommand {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(name, "name must not be null");
    }
}