package com.backintro.application.treatmentgoal.usecase;

import java.util.List;

import com.backintro.application.treatmentgoal.dto.TreatmentGoalResponse;
import com.backintro.domain.treatmentgoal.port.repository.TreatmentGoalRepository;
import com.backintro.domain.treatmentgoalstatus.port.repository.TreatmentGoalStatusRepository;

public class ListTreatmentGoalUseCase {
    private final TreatmentGoalRepository repository;
    private final TreatmentGoalStatusRepository treatmentGoalStatusRepository;

    public ListTreatmentGoalUseCase(
            TreatmentGoalRepository repository,
            TreatmentGoalStatusRepository treatmentGoalStatusRepository
    ) {
        this.repository = repository;
        this.treatmentGoalStatusRepository = treatmentGoalStatusRepository;
    }

    public List<TreatmentGoalResponse> execute() {
        return repository.findAll()
                .stream()
                .map(entity -> new TreatmentGoalResponse(
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
                ))
                .toList();
    }
}