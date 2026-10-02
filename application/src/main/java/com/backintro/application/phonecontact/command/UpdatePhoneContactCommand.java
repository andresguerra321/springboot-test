package com.backintro.application.phonecontact.command;

import java.util.Objects;
import java.util.UUID;

import com.backintro.domain.phonecontact.model.valueobject.PhoneContactId;

public record UpdatePhoneContactCommand(
        PhoneContactId id,
        UUID contactId,
        String phone,
        String notes
) {
    public UpdatePhoneContactCommand {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(contactId, "contactId must not be null");
        Objects.requireNonNull(phone, "phone must not be null");
    }
}