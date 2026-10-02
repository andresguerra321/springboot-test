package com.backintro.application.treatmentgoalstatus.usecase;

import java.util.List;

import com.backintro.application.treatmentgoalstatus.dto.TreatmentGoalStatusResponse;
import com.backintro.domain.treatmentgoalstatus.port.repository.TreatmentGoalStatusRepository;

public class ListTreatmentGoalStatusUseCase {

    private final TreatmentGoalStatusRepository repository;

    public ListTreatmentGoalStatusUseCase(
            TreatmentGoalStatusRepository repository
    ) {
        this.repository = repository;
    }

    public List<TreatmentGoalStatusResponse> execute() {

        return repository.findAll()
                .stream()
                .map(entity ->
                        new TreatmentGoalStatusResponse(
                entity.id().value(),
                entity.code(),
                entity.name(),
                entity.active(),
                entity.description(),
                null,
                null
                        )
                )
                .toList();
    }
}