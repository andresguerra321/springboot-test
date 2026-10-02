package com.backintro.application.treatmentgoalstatus.usecase;

import com.backintro.application.treatmentgoalstatus.command.UpdateTreatmentGoalStatusCommand;
import com.backintro.application.treatmentgoalstatus.dto.TreatmentGoalStatusResponse;
import com.backintro.application.treatmentgoalstatus.exception.TreatmentGoalStatusNotFoundApplicationException;
import com.backintro.domain.treatmentgoalstatus.port.repository.TreatmentGoalStatusRepository;

public class UpdateTreatmentGoalStatusUseCase {

    private final TreatmentGoalStatusRepository repository;

    public UpdateTreatmentGoalStatusUseCase(
            TreatmentGoalStatusRepository repository
    ) {
        this.repository = repository;
    }

    public TreatmentGoalStatusResponse execute(
            UpdateTreatmentGoalStatusCommand command
    ) {

        var entity =
                repository.findById(command.id())
                        .orElseThrow(() ->
                                new TreatmentGoalStatusNotFoundApplicationException(
                                        command.id()
                                                .value()
                                                .toString()
                                )
                        );

        entity.update(
                command.code(),
                command.name(),
                command.description()
        );

        var updated =
                repository.save(entity);

        return new TreatmentGoalStatusResponse(
                updated.id().value(),
                updated.code(),
                updated.name(),
                updated.active(),
                updated.description(),
                null,
                null
        );
    }
}