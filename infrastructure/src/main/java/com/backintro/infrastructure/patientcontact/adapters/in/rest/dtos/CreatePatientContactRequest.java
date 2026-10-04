package com.backintro.infrastructure.patientcontact.adapters.in.rest.dtos;

import java.util.UUID;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CreatePatientContactRequest(
        @NotNull(message = "contactId is required")
        UUID contactId,

        @NotNull(message = "patientId is required")
        UUID patientId,

        Boolean primaryContact,

        Boolean emergencyContact,

        UUID relationshipTypeId
) {}