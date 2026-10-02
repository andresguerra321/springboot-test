package com.backintro.application.chatconversationaisetting.command;

import java.util.Objects;
import java.util.UUID;

public record RegisterChatConversationAiSettingCommand(
        UUID conversationId,
        boolean aiEnabled,
        UUID defaultModelId
) {
    public RegisterChatConversationAiSettingCommand {
        Objects.requireNonNull(conversationId, "conversationId must not be null");
        Objects.requireNonNull(aiEnabled, "aiEnabled must not be null");
    }
}