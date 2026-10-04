package com.backintro.infrastructure.professional.adapters.in.rest.dtos;

import java.util.UUID;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UpdateProfessionalRequest(
        @NotNull(message = "documentTypeId is required")
        UUID documentTypeId,

        @NotBlank(message = "documentNumber is required")
        String documentNumber,

        @NotBlank(message = "firstName is required")
        String firstName,

        @NotBlank(message = "lastName is required")
        String lastName,

        @NotNull(message = "professionalTypeId is required")
        UUID professionalTypeId,

        String licenseNumber,

        UUID cityId
) {}