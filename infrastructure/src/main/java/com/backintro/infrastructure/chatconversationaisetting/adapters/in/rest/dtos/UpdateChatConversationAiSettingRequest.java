package com.backintro.infrastructure.chatconversationaisetting.adapters.in.rest.dtos;

import java.util.UUID;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UpdateChatConversationAiSettingRequest(
        @jakarta.validation.constraints.NotNull(message = "conversationId is required")
        UUID conversationId,

        boolean aiEnabled,

        UUID defaultModelId
) {}