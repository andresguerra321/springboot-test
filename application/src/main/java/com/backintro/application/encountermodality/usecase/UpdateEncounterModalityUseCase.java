package com.backintro.application.encountermodality.usecase;

import com.backintro.application.encountermodality.command.UpdateEncounterModalityCommand;
import com.backintro.application.encountermodality.dto.EncounterModalityResponse;
import com.backintro.application.encountermodality.exception.EncounterModalityNotFoundApplicationException;
import com.backintro.domain.encountermodality.port.repository.EncounterModalityRepository;

public class UpdateEncounterModalityUseCase {

    private final EncounterModalityRepository repository;

    public UpdateEncounterModalityUseCase(
            EncounterModalityRepository repository
    ) {
        this.repository = repository;
    }

    public EncounterModalityResponse execute(
            UpdateEncounterModalityCommand command
    ) {

        var entity =
                repository.findById(command.id())
                        .orElseThrow(() ->
                                new EncounterModalityNotFoundApplicationException(
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

        return new EncounterModalityResponse(
                updated.id().value(),
                updated.code(),
                updated.name(),
                updated.active(),
                null,
                null
        );
    }
}