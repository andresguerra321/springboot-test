package com.backintro.infrastructure.airunstatus.adapters.in.rest.dtos;

import java.util.UUID;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UpdateAiRunStatusRequest(
        @NotBlank(message = "nameStatus is required")
        String nameStatus
) {}