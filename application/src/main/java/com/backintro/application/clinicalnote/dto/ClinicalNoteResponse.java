package com.backintro.application.clinicalnote.dto;

import java.util.UUID;
import java.time.LocalDateTime;

public record ClinicalNoteResponse(
        UUID id,
        UUID encounterId,
        UUID professionalId,
        String professionalName,
        String subjective,
        String objective,
        String assessment,
        String plan,
        String additionalNotes,
        java.time.LocalDateTime signedAt,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}