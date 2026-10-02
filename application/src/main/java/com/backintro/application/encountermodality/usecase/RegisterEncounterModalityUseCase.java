package com.backintro.application.encountermodality.usecase;

import com.backintro.application.encountermodality.command.RegisterEncounterModalityCommand;
import com.backintro.application.encountermodality.dto.EncounterModalityResponse;
import com.backintro.domain.encountermodality.model.aggregate.EncounterModality;
import com.backintro.domain.encountermodality.port.repository.EncounterModalityRepository;

public class RegisterEncounterModalityUseCase {

    private final EncounterModalityRepository repository;

    public RegisterEncounterModalityUseCase(
            EncounterModalityRepository repository
    ) {
        this.repository = repository;
    }

    public EncounterModalityResponse execute(
            RegisterEncounterModalityCommand command
    ) {

        EncounterModality entity = EncounterModality.register(
                command.code(),
                command.name()
        );

        EncounterModality saved =
                repository.save(entity);

        return new EncounterModalityResponse(
                saved.id().value(),
                saved.code(),
                saved.name(),
                saved.active(),
                null,
                null
        );
    }
}