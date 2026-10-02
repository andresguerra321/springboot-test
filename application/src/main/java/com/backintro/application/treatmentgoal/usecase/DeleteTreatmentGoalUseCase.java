package com.backintro.application.treatmentgoal.usecase;

import java.time.LocalDateTime;

import com.backintro.application.treatmentgoal.exception.TreatmentGoalNotFoundApplicationException;
import com.backintro.domain.treatmentgoal.event.TreatmentGoalDeletedEvent;
import com.backintro.domain.treatmentgoal.model.valueobject.TreatmentGoalId;
import com.backintro.domain.treatmentgoal.port.repository.TreatmentGoalRepository;

public class DeleteTreatmentGoalUseCase {
    private final TreatmentGoalRepository repository;

    public DeleteTreatmentGoalUseCase(TreatmentGoalRepository repository) {
        this.repository = repository;
    }

    public TreatmentGoalDeletedEvent execute(TreatmentGoalId id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new TreatmentGoalNotFoundApplicationException(id.value().toString()));
        repository.delete(entity);
        return new TreatmentGoalDeletedEvent(id, LocalDateTime.now());
    }
}