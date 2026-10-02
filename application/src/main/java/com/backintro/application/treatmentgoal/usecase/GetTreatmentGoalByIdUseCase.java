package com.backintro.application.treatmentgoal.usecase;

import com.backintro.application.treatmentgoal.dto.TreatmentGoalResponse;
import com.backintro.application.treatmentgoal.exception.TreatmentGoalNotFoundApplicationException;
import com.backintro.domain.treatmentgoal.model.valueobject.TreatmentGoalId;
import com.backintro.domain.treatmentgoal.port.repository.TreatmentGoalRepository;
import com.backintro.domain.treatmentgoalstatus.port.repository.TreatmentGoalStatusRepository;

public class GetTreatmentGoalByIdUseCase {
    private final TreatmentGoalRepository repository;
    private final TreatmentGoalStatusRepository treatmentGoalStatusRepository;

    public GetTreatmentGoalByIdUseCase(
            TreatmentGoalRepository repository,
            TreatmentGoalStatusRepository treatmentGoalStatusRepository
    ) {
        this.repository = repository;
        this.treatmentGoalStatusRepository = treatmentGoalStatusRepository;
    }

    public TreatmentGoalResponse execute(TreatmentGoalId id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new TreatmentGoalNotFoundApplicationException(id.value().toString()));
        return new TreatmentGoalResponse(
                entity.id().value(),
                entity.treatmentPlanId(),
                entity.description(),
                entity.targetDate(),
                entity.completedAt(),
                entity.notes(),
                entity.treatmentGoalStatusId(),
                treatmentGoalStatusRepository.findById(new com.backintro.domain.treatmentgoalstatus.model.valueobject.TreatmentGoalStatusId(entity.treatmentGoalStatusId())).map(c -> c.name()).orElse(null),
                null,
                null
        );
    }
}