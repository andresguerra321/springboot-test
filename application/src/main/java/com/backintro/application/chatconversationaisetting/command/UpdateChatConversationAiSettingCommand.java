package com.backintro.application.chatconversationaisetting.command;

import java.util.Objects;
import java.util.UUID;

import com.backintro.domain.chatconversationaisetting.model.valueobject.ChatConversationAiSettingId;

public record UpdateChatConversationAiSettingCommand(
        ChatConversationAiSettingId id,
        UUID conversationId,
        boolean aiEnabled,
        UUID defaultModelId
) {
    public UpdateChatConversationAiSettingCommand {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(conversationId, "conversationId must not be null");
        Objects.requireNonNull(aiEnabled, "aiEnabled must not be null");
    }
}