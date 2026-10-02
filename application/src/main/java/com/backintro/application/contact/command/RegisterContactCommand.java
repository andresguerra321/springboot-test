package com.backintro.application.contact.command;

import java.util.Objects;
import java.util.UUID;

public record RegisterContactCommand(
        String fullName,
        String email,
        String notes,
        UUID cityId,
        UUID createdBy,
        UUID updatedBy
) {
    public RegisterContactCommand {
        Objects.requireNonNull(fullName, "fullName must not be null");
    }
}