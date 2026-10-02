package com.backintro.application.contact.command;

import java.util.Objects;
import java.util.UUID;

import com.backintro.domain.contact.model.valueobject.ContactId;

public record UpdateContactCommand(
        ContactId id,
        String fullName,
        String email,
        String notes,
        UUID cityId,
        UUID createdBy,
        UUID updatedBy
) {
    public UpdateContactCommand {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(fullName, "fullName must not be null");
    }
}