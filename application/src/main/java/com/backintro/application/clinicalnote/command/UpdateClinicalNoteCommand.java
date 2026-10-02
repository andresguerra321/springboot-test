package com.backintro.application.clinicalnote.command;

import java.util.Objects;
import java.util.UUID;

import com.backintro.domain.clinicalnote.model.valueobject.ClinicalNoteId;

public record UpdateClinicalNoteCommand(
        ClinicalNoteId id,
        UUID encounterId,
        UUID professionalId,
        String subjective,
        String objective,
        String assessment,
        String plan,
        String additionalNotes,
        java.time.LocalDateTime signedAt
) {
    public UpdateClinicalNoteCommand {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(encounterId, "encounterId must not be null");
        Objects.requireNonNull(professionalId, "professionalId must not be null");
    }
}