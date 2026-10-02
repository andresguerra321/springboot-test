package com.backintro.application.treatmentgoalstatus.usecase;

import java.time.LocalDateTime;

import com.backintro.application.treatmentgoalstatus.exception.TreatmentGoalStatusNotFoundApplicationException;
import com.backintro.domain.treatmentgoalstatus.event.TreatmentGoalStatusDeletedEvent;
import com.backintro.domain.treatmentgoalstatus.model.valueobject.TreatmentGoalStatusId;
import com.backintro.domain.treatmentgoalstatus.port.repository.TreatmentGoalStatusRepository;

public class DeleteTreatmentGoalStatusUseCase {

    private final TreatmentGoalStatusRepository repository;

    public DeleteTreatmentGoalStatusUseCase(
            TreatmentGoalStatusRepository repository
    ) {
        this.repository = repository;
    }

    public TreatmentGoalStatusDeletedEvent execute(
            TreatmentGoalStatusId id
    ) {

        var entity =
                repository.findById(id)
                        .orElseThrow(() ->
                                new TreatmentGoalStatusNotFoundApplicationException(
                                        id.value().toString()
                                )
                        );

        repository.delete(entity);

        return new TreatmentGoalStatusDeletedEvent(
                id,
                LocalDateTime.now()
        );
    }
}