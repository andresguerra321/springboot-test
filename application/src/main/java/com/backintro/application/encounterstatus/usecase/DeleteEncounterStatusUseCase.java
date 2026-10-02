package com.backintro.application.encounterstatus.usecase;

import java.time.LocalDateTime;

import com.backintro.application.encounterstatus.exception.EncounterStatusNotFoundApplicationException;
import com.backintro.domain.encounterstatus.event.EncounterStatusDeletedEvent;
import com.backintro.domain.encounterstatus.model.valueobject.EncounterStatusId;
import com.backintro.domain.encounterstatus.port.repository.EncounterStatusRepository;

public class DeleteEncounterStatusUseCase {

    private final EncounterStatusRepository repository;

    public DeleteEncounterStatusUseCase(
            EncounterStatusRepository repository
    ) {
        this.repository = repository;
    }

    public EncounterStatusDeletedEvent execute(
            EncounterStatusId id
    ) {

        var entity =
                repository.findById(id)
                        .orElseThrow(() ->
                                new EncounterStatusNotFoundApplicationException(
                                        id.value().toString()
                                )
                        );

        repository.delete(entity);

        return new EncounterStatusDeletedEvent(
                id,
                LocalDateTime.now()
        );
    }
}