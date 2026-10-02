package com.backintro.application.chatconversation.usecase;

import java.time.LocalDateTime;

import com.backintro.application.chatconversation.exception.ChatConversationNotFoundApplicationException;
import com.backintro.domain.chatconversation.event.ChatConversationDeletedEvent;
import com.backintro.domain.chatconversation.model.valueobject.ChatConversationId;
import com.backintro.domain.chatconversation.port.repository.ChatConversationRepository;

public class DeleteChatConversationUseCase {
    private final ChatConversationRepository repository;

    public DeleteChatConversationUseCase(ChatConversationRepository repository) {
        this.repository = repository;
    }

    public ChatConversationDeletedEvent execute(ChatConversationId id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new ChatConversationNotFoundApplicationException(id.value().toString()));
        repository.delete(entity);
        return new ChatConversationDeletedEvent(id, LocalDateTime.now());
    }
}