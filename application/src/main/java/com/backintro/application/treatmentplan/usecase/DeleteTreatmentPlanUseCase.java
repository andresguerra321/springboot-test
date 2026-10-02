package com.backintro.application.treatmentplan.usecase;

import java.time.LocalDateTime;

import com.backintro.application.treatmentplan.exception.TreatmentPlanNotFoundApplicationException;
import com.backintro.domain.treatmentplan.event.TreatmentPlanDeletedEvent;
import com.backintro.domain.treatmentplan.model.valueobject.TreatmentPlanId;
import com.backintro.domain.treatmentplan.port.repository.TreatmentPlanRepository;

public class DeleteTreatmentPlanUseCase {
    private final TreatmentPlanRepository repository;

    public DeleteTreatmentPlanUseCase(TreatmentPlanRepository repository) {
        this.repository = repository;
    }

    public TreatmentPlanDeletedEvent execute(TreatmentPlanId id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new TreatmentPlanNotFoundApplicationException(id.value().toString()));
        repository.delete(entity);
        return new TreatmentPlanDeletedEvent(id, LocalDateTime.now());
    }
}