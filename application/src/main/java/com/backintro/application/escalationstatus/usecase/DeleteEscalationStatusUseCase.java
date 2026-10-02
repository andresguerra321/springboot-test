package com.backintro.application.escalationstatus.usecase;

import java.time.LocalDateTime;

import com.backintro.application.escalationstatus.exception.EscalationStatusNotFoundApplicationException;
import com.backintro.domain.escalationstatus.event.EscalationStatusDeletedEvent;
import com.backintro.domain.escalationstatus.model.valueobject.EscalationStatusId;
import com.backintro.domain.escalationstatus.port.repository.EscalationStatusRepository;

public class DeleteEscalationStatusUseCase {
    private final EscalationStatusRepository repository;

    public DeleteEscalationStatusUseCase(EscalationStatusRepository repository) {
        this.repository = repository;
    }

    public EscalationStatusDeletedEvent execute(EscalationStatusId id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new EscalationStatusNotFoundApplicationException(id.value().toString()));
        repository.delete(entity);
        return new EscalationStatusDeletedEvent(id, LocalDateTime.now());
    }
}