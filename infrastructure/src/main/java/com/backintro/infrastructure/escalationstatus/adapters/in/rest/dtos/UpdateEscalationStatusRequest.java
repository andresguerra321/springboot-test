package com.backintro.infrastructure.escalationstatus.adapters.in.rest.dtos;

import java.util.UUID;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UpdateEscalationStatusRequest(
        @NotBlank(message = "nameStatus is required")
        String nameStatus
) {}