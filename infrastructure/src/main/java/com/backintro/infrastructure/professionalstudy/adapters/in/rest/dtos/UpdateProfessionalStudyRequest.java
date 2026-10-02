package com.backintro.infrastructure.professionalstudy.adapters.in.rest.dtos;

import java.util.UUID;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UpdateProfessionalStudyRequest(
        @jakarta.validation.constraints.NotNull(message = "studyId is required")
        UUID studyId,

        @jakarta.validation.constraints.NotNull(message = "professionalId is required")
        UUID professionalId,

        @NotBlank(message = "title is required")
        String title,

        String university,

        boolean valid,

        String resolutionNumber,

        UUID countryId
) {}