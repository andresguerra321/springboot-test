package com.backintro.application.conversationstatus.usecase;

import java.time.LocalDateTime;

import com.backintro.application.conversationstatus.exception.ConversationStatusNotFoundApplicationException;
import com.backintro.domain.conversationstatus.event.ConversationStatusDeletedEvent;
import com.backintro.domain.conversationstatus.model.valueobject.ConversationStatusId;
import com.backintro.domain.conversationstatus.port.repository.ConversationStatusRepository;

public class DeleteConversationStatusUseCase {
    private final ConversationStatusRepository repository;

    public DeleteConversationStatusUseCase(ConversationStatusRepository repository) {
        this.repository = repository;
    }

    public ConversationStatusDeletedEvent execute(ConversationStatusId id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new ConversationStatusNotFoundApplicationException(id.value().toString()));
        repository.delete(entity);
        return new ConversationStatusDeletedEvent(id, LocalDateTime.now());
    }
}