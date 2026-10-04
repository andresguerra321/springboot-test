package com.backintro.infrastructure.professionalstudy.adapters.in.rest.dtos;

import java.util.UUID;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CreateProfessionalStudyRequest(
        @NotNull(message = "studyId is required")
        UUID studyId,

        @NotNull(message = "professionalId is required")
        UUID professionalId,

        @NotBlank(message = "title is required")
        String title,

        String university,

        Boolean valid,

        String resolutionNumber,

        UUID countryId
) {}