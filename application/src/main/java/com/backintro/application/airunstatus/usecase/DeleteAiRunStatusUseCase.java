package com.backintro.application.airunstatus.usecase;

import java.time.LocalDateTime;

import com.backintro.application.airunstatus.exception.AiRunStatusNotFoundApplicationException;
import com.backintro.domain.airunstatus.event.AiRunStatusDeletedEvent;
import com.backintro.domain.airunstatus.model.valueobject.AiRunStatusId;
import com.backintro.domain.airunstatus.port.repository.AiRunStatusRepository;

public class DeleteAiRunStatusUseCase {
    private final AiRunStatusRepository repository;

    public DeleteAiRunStatusUseCase(AiRunStatusRepository repository) {
        this.repository = repository;
    }

    public AiRunStatusDeletedEvent execute(AiRunStatusId id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new AiRunStatusNotFoundApplicationException(id.value().toString()));
        repository.delete(entity);
        return new AiRunStatusDeletedEvent(id, LocalDateTime.now());
    }
}