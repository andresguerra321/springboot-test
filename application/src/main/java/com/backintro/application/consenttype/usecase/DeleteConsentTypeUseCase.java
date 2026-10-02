package com.backintro.application.consenttype.usecase;

import java.time.LocalDateTime;

import com.backintro.application.consenttype.exception.ConsentTypeNotFoundApplicationException;
import com.backintro.domain.consenttype.event.ConsentTypeDeletedEvent;
import com.backintro.domain.consenttype.model.valueobject.ConsentTypeId;
import com.backintro.domain.consenttype.port.repository.ConsentTypeRepository;

public class DeleteConsentTypeUseCase {

    private final ConsentTypeRepository repository;

    public DeleteConsentTypeUseCase(
            ConsentTypeRepository repository
    ) {
        this.repository = repository;
    }

    public ConsentTypeDeletedEvent execute(
            ConsentTypeId id
    ) {

        var entity =
                repository.findById(id)
                        .orElseThrow(() ->
                                new ConsentTypeNotFoundApplicationException(
                                        id.value().toString()
                                )
                        );

        repository.delete(entity);

        return new ConsentTypeDeletedEvent(
                id,
                LocalDateTime.now()
        );
    }
}