package com.backintro.infrastructure.conversationstatus.adapters.in.rest.dtos;

import java.util.UUID;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateConversationStatusRequest(
        @NotBlank(message = "nameStatus is required")
        String nameStatus
) {}