package com.backintro.application.encounterstatus.usecase;

import com.backintro.application.encounterstatus.command.UpdateEncounterStatusCommand;
import com.backintro.application.encounterstatus.dto.EncounterStatusResponse;
import com.backintro.application.encounterstatus.exception.EncounterStatusNotFoundApplicationException;
import com.backintro.domain.encounterstatus.port.repository.EncounterStatusRepository;

public class UpdateEncounterStatusUseCase {

    private final EncounterStatusRepository repository;

    public UpdateEncounterStatusUseCase(
            EncounterStatusRepository repository
    ) {
        this.repository = repository;
    }

    public EncounterStatusResponse execute(
            UpdateEncounterStatusCommand command
    ) {

        var entity =
                repository.findById(command.id())
                        .orElseThrow(() ->
                                new EncounterStatusNotFoundApplicationException(
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

        return new EncounterStatusResponse(
                updated.id().value(),
                updated.code(),
                updated.name(),
                updated.active(),
                null,
                null
        );
    }
}