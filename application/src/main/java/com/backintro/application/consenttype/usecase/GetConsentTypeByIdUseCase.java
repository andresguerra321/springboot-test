package com.backintro.application.consenttype.usecase;

import com.backintro.application.consenttype.dto.ConsentTypeResponse;
import com.backintro.application.consenttype.exception.ConsentTypeNotFoundApplicationException;
import com.backintro.domain.consenttype.model.valueobject.ConsentTypeId;
import com.backintro.domain.consenttype.port.repository.ConsentTypeRepository;

public class GetConsentTypeByIdUseCase {

    private final ConsentTypeRepository repository;

    public GetConsentTypeByIdUseCase(
            ConsentTypeRepository repository
    ) {
        this.repository = repository;
    }

    public ConsentTypeResponse execute(
            ConsentTypeId id
    ) {

        var entity =
                repository.findById(id)
                        .orElseThrow(() ->
                                new ConsentTypeNotFoundApplicationException(
                                        id.value().toString()
                                )
                        );

        return new ConsentTypeResponse(
                entity.id().value(),
                entity.code(),
                entity.name(),
                entity.active(),
                entity.description(),
                null,
                null
        );
    }
}