package com.backintro.infrastructure.priority.adapters.in.rest.dtos;

import java.util.UUID;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UpdatePriorityRequest(
        @NotBlank(message = "namePriority is required")
        String namePriority
) {}