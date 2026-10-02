package com.backintro.infrastructure.patientallergy.adapters.in.rest.dtos;

import java.util.UUID;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UpdatePatientAllergyRequest(
        @jakarta.validation.constraints.NotNull(message = "patientId is required")
        UUID patientId,

        @NotBlank(message = "substance is required")
        String substance,

        String reaction,

        String severity,

        java.time.LocalDateTime recordedAt,

        UUID recordedBy
) {}