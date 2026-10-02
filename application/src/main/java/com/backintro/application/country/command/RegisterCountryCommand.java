package com.backintro.application.country.command;

import java.util.Objects;
import java.util.UUID;

public record RegisterCountryCommand(
        String code,
        String name,
        String description,
        String telephonePrefix
) {
    public RegisterCountryCommand {
        Objects.requireNonNull(name, "name must not be null");
    }
}