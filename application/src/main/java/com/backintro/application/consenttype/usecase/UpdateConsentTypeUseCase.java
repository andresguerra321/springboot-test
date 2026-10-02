package com.backintro.application.consenttype.usecase;

import com.backintro.application.consenttype.command.UpdateConsentTypeCommand;
import com.backintro.application.consenttype.dto.ConsentTypeResponse;
import com.backintro.application.consenttype.exception.ConsentTypeNotFoundApplicationException;
import com.backintro.domain.consenttype.port.repository.ConsentTypeRepository;

public class UpdateConsentTypeUseCase {

    private final ConsentTypeRepository repository;

    public UpdateConsentTypeUseCase(
            ConsentTypeRepository repository
    ) {
        this.repository = repository;
    }

    public ConsentTypeResponse execute(
            UpdateConsentTypeCommand command
    ) {

        var entity =
                repository.findById(command.id())
                        .orElseThrow(() ->
                                new ConsentTypeNotFoundApplicationException(
                                        command.id()
                                                .value()
                                                .toString()
                                )
                        );

        entity.update(
                command.code(),
                command.name(),
                command.description()
        );

        var updated =
                repository.save(entity);

        return new ConsentTypeResponse(
                updated.id().value(),
                updated.code(),
                updated.name(),
                updated.active(),
                updated.description(),
                null,
                null
        );
    }
}