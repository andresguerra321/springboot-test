package com.backintro.application.chatconversationaisetting.usecase;

import java.time.LocalDateTime;

import com.backintro.application.chatconversationaisetting.exception.ChatConversationAiSettingNotFoundApplicationException;
import com.backintro.domain.chatconversationaisetting.event.ChatConversationAiSettingDeletedEvent;
import com.backintro.domain.chatconversationaisetting.model.valueobject.ChatConversationAiSettingId;
import com.backintro.domain.chatconversationaisetting.port.repository.ChatConversationAiSettingRepository;

public class DeleteChatConversationAiSettingUseCase {
    private final ChatConversationAiSettingRepository repository;

    public DeleteChatConversationAiSettingUseCase(ChatConversationAiSettingRepository repository) {
        this.repository = repository;
    }

    public ChatConversationAiSettingDeletedEvent execute(ChatConversationAiSettingId id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new ChatConversationAiSettingNotFoundApplicationException(id.value().toString()));
        repository.delete(entity);
        return new ChatConversationAiSettingDeletedEvent(id, LocalDateTime.now());
    }
}