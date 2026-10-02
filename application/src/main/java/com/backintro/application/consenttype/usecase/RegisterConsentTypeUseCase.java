package com.backintro.application.consenttype.usecase;

import com.backintro.application.consenttype.command.RegisterConsentTypeCommand;
import com.backintro.application.consenttype.dto.ConsentTypeResponse;
import com.backintro.domain.consenttype.model.aggregate.ConsentType;
import com.backintro.domain.consenttype.port.repository.ConsentTypeRepository;

public class RegisterConsentTypeUseCase {

    private final ConsentTypeRepository repository;

    public RegisterConsentTypeUseCase(
            ConsentTypeRepository repository
    ) {
        this.repository = repository;
    }

    public ConsentTypeResponse execute(
            RegisterConsentTypeCommand command
    ) {

        ConsentType entity = ConsentType.register(
                command.code(),
                command.name(),
                command.description()
        );

        ConsentType saved =
                repository.save(entity);

        return new ConsentTypeResponse(
                saved.id().value(),
                saved.code(),
                saved.name(),
                saved.active(),
                saved.description(),
                null,
                null
        );
    }
}