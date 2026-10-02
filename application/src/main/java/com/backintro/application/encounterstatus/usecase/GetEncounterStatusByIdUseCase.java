package com.backintro.application.encounterstatus.usecase;

import com.backintro.application.encounterstatus.dto.EncounterStatusResponse;
import com.backintro.application.encounterstatus.exception.EncounterStatusNotFoundApplicationException;
import com.backintro.domain.encounterstatus.model.valueobject.EncounterStatusId;
import com.backintro.domain.encounterstatus.port.repository.EncounterStatusRepository;

public class GetEncounterStatusByIdUseCase {

    private final EncounterStatusRepository repository;

    public GetEncounterStatusByIdUseCase(
            EncounterStatusRepository repository
    ) {
        this.repository = repository;
    }

    public EncounterStatusResponse execute(
            EncounterStatusId id
    ) {

        var entity =
                repository.findById(id)
                        .orElseThrow(() ->
                                new EncounterStatusNotFoundApplicationException(
                                        id.value().toString()
                                )
                        );

        return new EncounterStatusResponse(
                entity.id().value(),
                entity.code(),
                entity.name(),
                entity.active(),
                null,
                null
        );
    }
}