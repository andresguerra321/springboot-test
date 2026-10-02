package com.backintro.application.treatmentgoal.usecase;

import com.backintro.application.treatmentgoal.command.UpdateTreatmentGoalCommand;
import com.backintro.application.treatmentgoal.dto.TreatmentGoalResponse;
import com.backintro.application.treatmentgoal.exception.TreatmentGoalNotFoundApplicationException;
import com.backintro.domain.treatmentgoal.port.repository.TreatmentGoalRepository;
import com.backintro.domain.treatmentgoalstatus.port.repository.TreatmentGoalStatusRepository;

public class UpdateTreatmentGoalUseCase {
    private final TreatmentGoalRepository repository;
    private final TreatmentGoalStatusRepository treatmentGoalStatusRepository;

    public UpdateTreatmentGoalUseCase(
            TreatmentGoalRepository repository,
            TreatmentGoalStatusRepository treatmentGoalStatusRepository
    ) {
        this.repository = repository;
        this.treatmentGoalStatusRepository = treatmentGoalStatusRepository;
    }

    public TreatmentGoalResponse execute(UpdateTreatmentGoalCommand command) {
        var entity = repository.findById(command.id())
                .orElseThrow(() -> new TreatmentGoalNotFoundApplicationException(command.id().value().toString()));

        entity.update(
                command.treatmentPlanId(),
                command.description(),
                command.targetDate(),
                command.completedAt(),
                command.notes(),
                command.treatmentGoalStatusId()
        );

        var updated = repository.save(entity);
        return new TreatmentGoalResponse(
                updated.id().value(),
                updated.treatmentPlanId(),
                updated.description(),
                updated.targetDate(),
                updated.completedAt(),
                updated.notes(),
                updated.treatmentGoalStatusId(),
                treatmentGoalStatusRepository.findById(new com.backintro.domain.treatmentgoalstatus.model.valueobject.TreatmentGoalStatusId(updated.treatmentGoalStatusId())).map(c -> c.name()).orElse(null),
                null,
                null
        );
    }
}