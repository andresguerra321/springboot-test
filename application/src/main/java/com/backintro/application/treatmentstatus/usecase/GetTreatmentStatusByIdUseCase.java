package com.backintro.application.treatmentstatus.usecase;

import com.backintro.application.treatmentstatus.dto.TreatmentStatusResponse;
import com.backintro.application.treatmentstatus.exception.TreatmentStatusNotFoundApplicationException;
import com.backintro.domain.treatmentstatus.model.valueobject.TreatmentStatusId;
import com.backintro.domain.treatmentstatus.port.repository.TreatmentStatusRepository;

public class GetTreatmentStatusByIdUseCase {

    private final TreatmentStatusRepository repository;

    public GetTreatmentStatusByIdUseCase(
            TreatmentStatusRepository repository
    ) {
        this.repository = repository;
    }

    public TreatmentStatusResponse execute(
            TreatmentStatusId id
    ) {

        var entity =
                repository.findById(id)
                        .orElseThrow(() ->
                                new TreatmentStatusNotFoundApplicationException(
                                        id.value().toString()
                                )
                        );

        return new TreatmentStatusResponse(
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