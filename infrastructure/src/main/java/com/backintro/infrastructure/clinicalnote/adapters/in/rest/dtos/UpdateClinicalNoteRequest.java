package com.backintro.infrastructure.clinicalnote.adapters.in.rest.dtos;

import java.util.UUID;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UpdateClinicalNoteRequest(
        @jakarta.validation.constraints.NotNull(message = "encounterId is required")
        UUID encounterId,

        @jakarta.validation.constraints.NotNull(message = "professionalId is required")
        UUID professionalId,

        String subjective,

        String objective,

        String assessment,

        String plan,

        String additionalNotes,

        java.time.LocalDateTime signedAt
) {}