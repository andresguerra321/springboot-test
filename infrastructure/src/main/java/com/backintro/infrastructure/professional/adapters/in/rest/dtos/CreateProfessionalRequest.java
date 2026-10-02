package com.backintro.infrastructure.professional.adapters.in.rest.dtos;

import java.util.UUID;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateProfessionalRequest(
        @jakarta.validation.constraints.NotNull(message = "documentTypeId is required")
        UUID documentTypeId,

        @NotBlank(message = "documentNumber is required")
        String documentNumber,

        @NotBlank(message = "firstName is required")
        String firstName,

        @NotBlank(message = "lastName is required")
        String lastName,

        @jakarta.validation.constraints.NotNull(message = "professionalTypeId is required")
        UUID professionalTypeId,

        String licenseNumber,

        UUID cityId
) {}