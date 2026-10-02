package com.backintro.application.patientallergy.command;

import java.util.Objects;
import java.util.UUID;

import com.backintro.domain.patientallergy.model.valueobject.PatientAllergyId;

public record UpdatePatientAllergyCommand(
        PatientAllergyId id,
        UUID patientId,
        String substance,
        String reaction,
        String severity,
        java.time.LocalDateTime recordedAt,
        UUID recordedBy
) {
    public UpdatePatientAllergyCommand {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(patientId, "patientId must not be null");
        Objects.requireNonNull(substance, "substance must not be null");
    }
}