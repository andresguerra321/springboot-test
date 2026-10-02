package com.backintro.application.emailcontact.command;

import java.util.Objects;
import java.util.UUID;

import com.backintro.domain.emailcontact.model.valueobject.EmailContactId;

public record UpdateEmailContactCommand(
        EmailContactId id,
        UUID contactId,
        String email,
        String notes
) {
    public UpdateEmailContactCommand {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(contactId, "contactId must not be null");
        Objects.requireNonNull(email, "email must not be null");
    }
}