package com.backintro.infrastructure.treatmentplan.adapters.in.rest.dtos;

import java.util.UUID;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UpdateTreatmentPlanRequest(
        @NotNull(message = "encounterId is required")
        UUID encounterId,

        @NotNull(message = "professionalId is required")
        UUID professionalId,

        @NotBlank(message = "title is required")
        String title,

        String description,

        java.time.LocalDate startDate,

        java.time.LocalDate endDate,

        @NotNull(message = "treatmentStatusId is required")
        UUID treatmentStatusId
) {}