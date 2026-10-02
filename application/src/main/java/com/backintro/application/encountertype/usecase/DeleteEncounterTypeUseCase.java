package com.backintro.application.encountertype.usecase;

import java.time.LocalDateTime;

import com.backintro.application.encountertype.exception.EncounterTypeNotFoundApplicationException;
import com.backintro.domain.encountertype.event.EncounterTypeDeletedEvent;
import com.backintro.domain.encountertype.model.valueobject.EncounterTypeId;
import com.backintro.domain.encountertype.port.repository.EncounterTypeRepository;

public class DeleteEncounterTypeUseCase {

    private final EncounterTypeRepository repository;

    public DeleteEncounterTypeUseCase(
            EncounterTypeRepository repository
    ) {
        this.repository = repository;
    }

    public EncounterTypeDeletedEvent execute(
            EncounterTypeId id
    ) {

        var entity =
                repository.findById(id)
                        .orElseThrow(() ->
                                new EncounterTypeNotFoundApplicationException(
                                        id.value().toString()
                                )
                        );

        repository.delete(entity);

        return new EncounterTypeDeletedEvent(
                id,
                LocalDateTime.now()
        );
    }
}