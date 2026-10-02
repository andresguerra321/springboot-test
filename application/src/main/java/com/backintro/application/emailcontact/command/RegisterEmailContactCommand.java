package com.backintro.application.emailcontact.command;

import java.util.Objects;
import java.util.UUID;

public record RegisterEmailContactCommand(
        UUID contactId,
        String email,
        String notes
) {
    public RegisterEmailContactCommand {
        Objects.requireNonNull(contactId, "contactId must not be null");
        Objects.requireNonNull(email, "email must not be null");
    }
}