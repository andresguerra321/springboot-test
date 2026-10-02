package com.backintro.application.stateregion.usecase;

import java.time.LocalDateTime;

import com.backintro.application.stateregion.exception.StateRegionNotFoundApplicationException;
import com.backintro.domain.stateregion.event.StateRegionDeletedEvent;
import com.backintro.domain.stateregion.model.valueobject.StateRegionId;
import com.backintro.domain.stateregion.port.repository.StateRegionRepository;

public class DeleteStateRegionUseCase {
    private final StateRegionRepository repository;

    public DeleteStateRegionUseCase(StateRegionRepository repository) {
        this.repository = repository;
    }

    public StateRegionDeletedEvent execute(StateRegionId id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new StateRegionNotFoundApplicationException(id.value().toString()));
        repository.delete(entity);
        return new StateRegionDeletedEvent(id, LocalDateTime.now());
    }
}