package com.backintro.infrastructure.messagetype.adapters.in.rest.dtos;

import java.util.UUID;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateMessageTypeRequest(
        @NotBlank(message = "nameType is required")
        String nameType
) {}