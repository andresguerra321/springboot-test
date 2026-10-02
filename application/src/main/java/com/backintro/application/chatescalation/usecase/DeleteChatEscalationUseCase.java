package com.backintro.application.chatescalation.usecase;

import java.time.LocalDateTime;

import com.backintro.application.chatescalation.exception.ChatEscalationNotFoundApplicationException;
import com.backintro.domain.chatescalation.event.ChatEscalationDeletedEvent;
import com.backintro.domain.chatescalation.model.valueobject.ChatEscalationId;
import com.backintro.domain.chatescalation.port.repository.ChatEscalationRepository;

public class DeleteChatEscalationUseCase {
    private final ChatEscalationRepository repository;

    public DeleteChatEscalationUseCase(ChatEscalationRepository repository) {
        this.repository = repository;
    }

    public ChatEscalationDeletedEvent execute(ChatEscalationId id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new ChatEscalationNotFoundApplicationException(id.value().toString()));
        repository.delete(entity);
        return new ChatEscalationDeletedEvent(id, LocalDateTime.now());
    }
}