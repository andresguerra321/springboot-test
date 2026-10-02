package com.backintro.application.encounterstatus.usecase;

import com.backintro.application.encounterstatus.command.RegisterEncounterStatusCommand;
import com.backintro.application.encounterstatus.dto.EncounterStatusResponse;
import com.backintro.domain.encounterstatus.model.aggregate.EncounterStatus;
import com.backintro.domain.encounterstatus.port.repository.EncounterStatusRepository;

public class RegisterEncounterStatusUseCase {

    private final EncounterStatusRepository repository;

    public RegisterEncounterStatusUseCase(
            EncounterStatusRepository repository
    ) {
        this.repository = repository;
    }

    public EncounterStatusResponse execute(
            RegisterEncounterStatusCommand command
    ) {

        EncounterStatus entity = EncounterStatus.register(
                command.code(),
                command.name()
        );

        EncounterStatus saved =
                repository.save(entity);

        return new EncounterStatusResponse(
                saved.id().value(),
                saved.code(),
                saved.name(),
                saved.active(),
                null,
                null
        );
    }
}