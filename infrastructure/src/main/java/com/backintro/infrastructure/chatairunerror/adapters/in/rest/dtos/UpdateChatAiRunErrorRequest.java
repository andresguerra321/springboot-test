package com.backintro.infrastructure.chatairunerror.adapters.in.rest.dtos;

import java.util.UUID;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UpdateChatAiRunErrorRequest(
        @jakarta.validation.constraints.NotNull(message = "aiRunId is required")
        UUID aiRunId,

        String errorMessage,

        String errorCode,

        String providerErrorId
) {}