package com.backintro.application.encounter.usecase;

import java.time.LocalDateTime;

import com.backintro.application.encounter.exception.EncounterNotFoundApplicationException;
import com.backintro.domain.encounter.event.EncounterDeletedEvent;
import com.backintro.domain.encounter.model.valueobject.EncounterId;
import com.backintro.domain.encounter.port.repository.EncounterRepository;

public class DeleteEncounterUseCase {
    private final EncounterRepository repository;

    public DeleteEncounterUseCase(EncounterRepository repository) {
        this.repository = repository;
    }

    public EncounterDeletedEvent execute(EncounterId id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new EncounterNotFoundApplicationException(id.value().toString()));
        repository.delete(entity);
        return new EncounterDeletedEvent(id, LocalDateTime.now());
    }
}