package com.backintro.application.clinicalnote.command;

import java.util.Objects;
import java.util.UUID;

public record RegisterClinicalNoteCommand(
        UUID encounterId,
        UUID professionalId,
        String subjective,
        String objective,
        String assessment,
        String plan,
        String additionalNotes,
        java.time.LocalDateTime signedAt
) {
    public RegisterClinicalNoteCommand {
        Objects.requireNonNull(encounterId, "encounterId must not be null");
        Objects.requireNonNull(professionalId, "professionalId must not be null");
    }
}