package com.backintro.application.treatmentstatus.usecase;

import com.backintro.application.treatmentstatus.command.UpdateTreatmentStatusCommand;
import com.backintro.application.treatmentstatus.dto.TreatmentStatusResponse;
import com.backintro.application.treatmentstatus.exception.TreatmentStatusNotFoundApplicationException;
import com.backintro.domain.treatmentstatus.port.repository.TreatmentStatusRepository;

public class UpdateTreatmentStatusUseCase {

    private final TreatmentStatusRepository repository;

    public UpdateTreatmentStatusUseCase(
            TreatmentStatusRepository repository
    ) {
        this.repository = repository;
    }

    public TreatmentStatusResponse execute(
            UpdateTreatmentStatusCommand command
    ) {

        var entity =
                repository.findById(command.id())
                        .orElseThrow(() ->
                                new TreatmentStatusNotFoundApplicationException(
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

        return new TreatmentStatusResponse(
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