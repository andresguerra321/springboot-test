package com.backintro.infrastructure.patient.adapters.in.rest.dtos;

import java.util.UUID;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreatePatientRequest(
        @jakarta.validation.constraints.NotNull(message = "documentTypeId is required")
        UUID documentTypeId,

        @NotBlank(message = "documentNumber is required")
        String documentNumber,

        @NotBlank(message = "firstName is required")
        String firstName,

        String middleName,

        @NotBlank(message = "lastName is required")
        String lastName,

        String secondLastName,

        java.time.LocalDate birthDate,

        @jakarta.validation.constraints.NotNull(message = "biologicalSexId is required")
        UUID biologicalSexId,

        UUID genderIdentity,

        String email,

        String phone,

        String address,

        UUID cityId,

        UUID createdBy,

        UUID updatedBy
) {}