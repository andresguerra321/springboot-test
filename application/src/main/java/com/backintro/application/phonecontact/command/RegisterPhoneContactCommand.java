package com.backintro.application.phonecontact.command;

import java.util.Objects;
import java.util.UUID;

public record RegisterPhoneContactCommand(
        UUID contactId,
        String phone,
        String notes
) {
    public RegisterPhoneContactCommand {
        Objects.requireNonNull(contactId, "contactId must not be null");
        Objects.requireNonNull(phone, "phone must not be null");
    }
}