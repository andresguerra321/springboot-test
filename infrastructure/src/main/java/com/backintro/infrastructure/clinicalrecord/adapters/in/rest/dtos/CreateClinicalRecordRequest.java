package com.backintro.infrastructure.clinicalrecord.adapters.in.rest.dtos;

import java.util.UUID;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateClinicalRecordRequest(
        @jakarta.validation.constraints.NotNull(message = "patientId is required")
        UUID patientId,

        java.time.LocalDateTime creationDate,

        @NotBlank(message = "recordNumber is required")
        String recordNumber,

        java.time.LocalDateTime openedAt,

        java.time.LocalDateTime closedAt,

        @jakarta.validation.constraints.NotNull(message = "statusId is required")
        UUID statusId,

        UUID createdBy
) {}