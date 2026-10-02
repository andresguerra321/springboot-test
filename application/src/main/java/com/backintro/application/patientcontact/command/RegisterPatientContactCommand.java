package com.backintro.application.patientcontact.command;

import java.util.Objects;
import java.util.UUID;

public record RegisterPatientContactCommand(
        UUID contactId,
        UUID patientId,
        boolean primaryContact,
        boolean emergencyContact,
        UUID relationshipTypeId
) {
    public RegisterPatientContactCommand {
        Objects.requireNonNull(contactId, "contactId must not be null");
        Objects.requireNonNull(patientId, "patientId must not be null");
    }
}