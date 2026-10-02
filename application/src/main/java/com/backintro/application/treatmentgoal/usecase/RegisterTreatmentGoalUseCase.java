package com.backintro.application.treatmentgoal.usecase;

import com.backintro.application.treatmentgoal.command.RegisterTreatmentGoalCommand;
import com.backintro.application.treatmentgoal.dto.TreatmentGoalResponse;
import com.backintro.domain.treatmentgoal.model.aggregate.TreatmentGoal;
import com.backintro.domain.treatmentgoal.port.repository.TreatmentGoalRepository;
import com.backintro.domain.treatmentgoalstatus.port.repository.TreatmentGoalStatusRepository;

public class RegisterTreatmentGoalUseCase {
    private final TreatmentGoalRepository repository;
    private final TreatmentGoalStatusRepository treatmentGoalStatusRepository;

    public RegisterTreatmentGoalUseCase(
            TreatmentGoalRepository repository,
            TreatmentGoalStatusRepository treatmentGoalStatusRepository
    ) {
        this.repository = repository;
        this.treatmentGoalStatusRepository = treatmentGoalStatusRepository;
    }

    public TreatmentGoalResponse execute(RegisterTreatmentGoalCommand command) {
        TreatmentGoal entity = TreatmentGoal.register(
                command.treatmentPlanId(),
                command.description(),
                command.targetDate(),
                command.completedAt(),
                command.notes(),
                command.treatmentGoalStatusId()
        );
        TreatmentGoal saved = repository.save(entity);
        return new TreatmentGoalResponse(
                saved.id().value(),
                saved.treatmentPlanId(),
                saved.description(),
                saved.targetDate(),
                saved.completedAt(),
                saved.notes(),
                saved.treatmentGoalStatusId(),
                treatmentGoalStatusRepository.findById(new com.backintro.domain.treatmentgoalstatus.model.valueobject.TreatmentGoalStatusId(saved.treatmentGoalStatusId())).map(c -> c.name()).orElse(null),
                null,
                null
        );
    }
}