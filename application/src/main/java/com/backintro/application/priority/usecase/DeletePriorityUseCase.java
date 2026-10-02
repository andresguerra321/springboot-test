package com.backintro.application.priority.usecase;

import java.time.LocalDateTime;

import com.backintro.application.priority.exception.PriorityNotFoundApplicationException;
import com.backintro.domain.priority.event.PriorityDeletedEvent;
import com.backintro.domain.priority.model.valueobject.PriorityId;
import com.backintro.domain.priority.port.repository.PriorityRepository;

public class DeletePriorityUseCase {
    private final PriorityRepository repository;

    public DeletePriorityUseCase(PriorityRepository repository) {
        this.repository = repository;
    }

    public PriorityDeletedEvent execute(PriorityId id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new PriorityNotFoundApplicationException(id.value().toString()));
        repository.delete(entity);
        return new PriorityDeletedEvent(id, LocalDateTime.now());
    }
}