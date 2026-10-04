package com.backintro.infrastructure.emailcontact.adapters.in.rest.dtos;

import java.util.UUID;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CreateEmailContactRequest(
        @NotNull(message = "contactId is required")
        UUID contactId,

        @NotBlank(message = "email is required")
        String email,

        String notes
) {}