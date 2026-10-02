package com.backintro.application.treatmentgoalstatus.usecase;

import com.backintro.application.treatmentgoalstatus.command.RegisterTreatmentGoalStatusCommand;
import com.backintro.application.treatmentgoalstatus.dto.TreatmentGoalStatusResponse;
import com.backintro.domain.treatmentgoalstatus.model.aggregate.TreatmentGoalStatus;
import com.backintro.domain.treatmentgoalstatus.port.repository.TreatmentGoalStatusRepository;

public class RegisterTreatmentGoalStatusUseCase {

    private final TreatmentGoalStatusRepository repository;

    public RegisterTreatmentGoalStatusUseCase(
            TreatmentGoalStatusRepository repository
    ) {
        this.repository = repository;
    }

    public TreatmentGoalStatusResponse execute(
            RegisterTreatmentGoalStatusCommand command
    ) {

        TreatmentGoalStatus entity = TreatmentGoalStatus.register(
                command.code(),
                command.name(),
                command.description()
        );

        TreatmentGoalStatus saved =
                repository.save(entity);

        return new TreatmentGoalStatusResponse(
                saved.id().value(),
                saved.code(),
                saved.name(),
                saved.active(),
                saved.description(),
                null,
                null
        );
    }
}