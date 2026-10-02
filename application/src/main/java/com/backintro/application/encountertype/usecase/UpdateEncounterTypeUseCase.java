package com.backintro.application.encountertype.usecase;

import com.backintro.application.encountertype.command.UpdateEncounterTypeCommand;
import com.backintro.application.encountertype.dto.EncounterTypeResponse;
import com.backintro.application.encountertype.exception.EncounterTypeNotFoundApplicationException;
import com.backintro.domain.encountertype.port.repository.EncounterTypeRepository;

public class UpdateEncounterTypeUseCase {

    private final EncounterTypeRepository repository;

    public UpdateEncounterTypeUseCase(
            EncounterTypeRepository repository
    ) {
        this.repository = repository;
    }

    public EncounterTypeResponse execute(
            UpdateEncounterTypeCommand command
    ) {

        var entity =
                repository.findById(command.id())
                        .orElseThrow(() ->
                                new EncounterTypeNotFoundApplicationException(
                                        command.id()
                                                .value()
                                                .toString()
                                )
                        );

        entity.update(
                command.code(),
                command.name()
        );

        var updated =
                repository.save(entity);

        return new EncounterTypeResponse(
                updated.id().value(),
                updated.code(),
                updated.name(),
                updated.active(),
                null,
                null
        );
    }
}