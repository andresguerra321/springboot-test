package com.backintro.infrastructure.patientcontact.adapters.in.rest.dtos;

import java.util.UUID;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreatePatientContactRequest(
        @jakarta.validation.constraints.NotNull(message = "contactId is required")
        UUID contactId,

        @jakarta.validation.constraints.NotNull(message = "patientId is required")
        UUID patientId,

        boolean primaryContact,

        boolean emergencyContact,

        UUID relationshipTypeId
) {}