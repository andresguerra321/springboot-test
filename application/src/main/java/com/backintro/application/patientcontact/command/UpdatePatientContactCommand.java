package com.backintro.application.patientcontact.command;

import java.util.Objects;
import java.util.UUID;

import com.backintro.domain.patientcontact.model.valueobject.PatientContactId;

public record UpdatePatientContactCommand(
        PatientContactId id,
        UUID contactId,
        UUID patientId,
        Boolean primaryContact,
        Boolean emergencyContact,
        UUID relationshipTypeId
) {
    public UpdatePatientContactCommand {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(contactId, "contactId must not be null");
        Objects.requireNonNull(patientId, "patientId must not be null");
    }
}