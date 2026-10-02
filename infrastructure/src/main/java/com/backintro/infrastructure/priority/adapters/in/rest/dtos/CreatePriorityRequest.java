package com.backintro.infrastructure.priority.adapters.in.rest.dtos;

import java.util.UUID;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreatePriorityRequest(
        @NotBlank(message = "namePriority is required")
        String namePriority
) {}