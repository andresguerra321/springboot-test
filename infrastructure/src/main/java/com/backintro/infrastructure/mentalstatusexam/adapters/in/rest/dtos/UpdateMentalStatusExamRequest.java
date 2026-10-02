package com.backintro.infrastructure.mentalstatusexam.adapters.in.rest.dtos;

import java.util.UUID;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UpdateMentalStatusExamRequest(
        @jakarta.validation.constraints.NotNull(message = "encounterId is required")
        UUID encounterId,

        String appearance,

        String behavior,

        String attitude,

        String consciousness,

        String orientation,

        String attention,

        String memory,

        String speech,

        String mood,

        String affect,

        String thoughtProcess,

        String thoughtContent,

        String perception,

        String judgment,

        String insight,

        String psychomotorActivity,

        String observations,

        UUID createdBy
) {}