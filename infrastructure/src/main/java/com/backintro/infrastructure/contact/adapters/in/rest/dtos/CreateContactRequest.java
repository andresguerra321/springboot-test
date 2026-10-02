package com.backintro.infrastructure.contact.adapters.in.rest.dtos;

import java.util.UUID;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateContactRequest(
        @NotBlank(message = "fullName is required")
        String fullName,

        String email,

        String notes,

        UUID cityId,

        UUID createdBy,

        UUID updatedBy
) {}