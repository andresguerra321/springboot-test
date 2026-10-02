package com.backintro.infrastructure.phonecontact.adapters.in.rest.dtos;

import java.util.UUID;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UpdatePhoneContactRequest(
        @jakarta.validation.constraints.NotNull(message = "contactId is required")
        UUID contactId,

        @NotBlank(message = "phone is required")
        String phone,

        String notes
) {}