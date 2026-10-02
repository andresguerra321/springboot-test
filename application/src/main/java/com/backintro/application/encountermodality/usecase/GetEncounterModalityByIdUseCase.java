package com.backintro.application.encountermodality.usecase;

import com.backintro.application.encountermodality.dto.EncounterModalityResponse;
import com.backintro.application.encountermodality.exception.EncounterModalityNotFoundApplicationException;
import com.backintro.domain.encountermodality.model.valueobject.EncounterModalityId;
import com.backintro.domain.encountermodality.port.repository.EncounterModalityRepository;

public class GetEncounterModalityByIdUseCase {

    private final EncounterModalityRepository repository;

    public GetEncounterModalityByIdUseCase(
            EncounterModalityRepository repository
    ) {
        this.repository = repository;
    }

    public EncounterModalityResponse execute(
            EncounterModalityId id
    ) {

        var entity =
                repository.findById(id)
                        .orElseThrow(() ->
                                new EncounterModalityNotFoundApplicationException(
                                        id.value().toString()
                                )
                        );

        return new EncounterModalityResponse(
                entity.id().value(),
                entity.code(),
                entity.name(),
                entity.active(),
                null,
                null
        );
    }
}