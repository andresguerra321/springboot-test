package com.backintro.application.chatescalationstatushistory.usecase;

import java.time.LocalDateTime;

import com.backintro.application.chatescalationstatushistory.exception.ChatEscalationStatusHistoryNotFoundApplicationException;
import com.backintro.domain.chatescalationstatushistory.event.ChatEscalationStatusHistoryDeletedEvent;
import com.backintro.domain.chatescalationstatushistory.model.valueobject.ChatEscalationStatusHistoryId;
import com.backintro.domain.chatescalationstatushistory.port.repository.ChatEscalationStatusHistoryRepository;

public class DeleteChatEscalationStatusHistoryUseCase {
    private final ChatEscalationStatusHistoryRepository repository;

    public DeleteChatEscalationStatusHistoryUseCase(ChatEscalationStatusHistoryRepository repository) {
        this.repository = repository;
    }

    public ChatEscalationStatusHistoryDeletedEvent execute(ChatEscalationStatusHistoryId id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new ChatEscalationStatusHistoryNotFoundApplicationException(id.value().toString()));
        repository.delete(entity);
        return new ChatEscalationStatusHistoryDeletedEvent(id, LocalDateTime.now());
    }
}