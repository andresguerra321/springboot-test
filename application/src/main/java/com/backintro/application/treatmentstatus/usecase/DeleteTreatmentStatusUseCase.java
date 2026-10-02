package com.backintro.application.treatmentstatus.usecase;

import java.time.LocalDateTime;

import com.backintro.application.treatmentstatus.exception.TreatmentStatusNotFoundApplicationException;
import com.backintro.domain.treatmentstatus.event.TreatmentStatusDeletedEvent;
import com.backintro.domain.treatmentstatus.model.valueobject.TreatmentStatusId;
import com.backintro.domain.treatmentstatus.port.repository.TreatmentStatusRepository;

public class DeleteTreatmentStatusUseCase {

    private final TreatmentStatusRepository repository;

    public DeleteTreatmentStatusUseCase(
            TreatmentStatusRepository repository
    ) {
        this.repository = repository;
    }

    public TreatmentStatusDeletedEvent execute(
            TreatmentStatusId id
    ) {

        var entity =
                repository.findById(id)
                        .orElseThrow(() ->
                                new TreatmentStatusNotFoundApplicationException(
                                        id.value().toString()
                                )
                        );

        repository.delete(entity);

        return new TreatmentStatusDeletedEvent(
                id,
                LocalDateTime.now()
        );
    }
}