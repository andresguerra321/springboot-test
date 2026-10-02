package com.backintro.application.patientallergy.command;

import java.util.Objects;
import java.util.UUID;

public record RegisterPatientAllergyCommand(
        UUID patientId,
        String substance,
        String reaction,
        String severity,
        java.time.LocalDateTime recordedAt,
        UUID recordedBy
) {
    public RegisterPatientAllergyCommand {
        Objects.requireNonNull(patientId, "patientId must not be null");
        Objects.requireNonNull(substance, "substance must not be null");
    }
}