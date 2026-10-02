package com.backintro.application.encountertype.usecase;

import com.backintro.application.encountertype.command.RegisterEncounterTypeCommand;
import com.backintro.application.encountertype.dto.EncounterTypeResponse;
import com.backintro.domain.encountertype.model.aggregate.EncounterType;
import com.backintro.domain.encountertype.port.repository.EncounterTypeRepository;

public class RegisterEncounterTypeUseCase {

    private final EncounterTypeRepository repository;

    public RegisterEncounterTypeUseCase(
            EncounterTypeRepository repository
    ) {
        this.repository = repository;
    }

    public EncounterTypeResponse execute(
            RegisterEncounterTypeCommand command
    ) {

        EncounterType entity = EncounterType.register(
                command.code(),
                command.name()
        );

        EncounterType saved =
                repository.save(entity);

        return new EncounterTypeResponse(
                saved.id().value(),
                saved.code(),
                saved.name(),
                saved.active(),
                null,
                null
        );
    }
}