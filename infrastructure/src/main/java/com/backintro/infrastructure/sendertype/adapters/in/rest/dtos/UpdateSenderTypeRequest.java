package com.backintro.infrastructure.sendertype.adapters.in.rest.dtos;

import java.util.UUID;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UpdateSenderTypeRequest(
        @NotBlank(message = "nameType is required")
        String nameType
) {}