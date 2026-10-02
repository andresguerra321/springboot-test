package com.backintro.application.treatmentstatus.usecase;

import com.backintro.application.treatmentstatus.command.RegisterTreatmentStatusCommand;
import com.backintro.application.treatmentstatus.dto.TreatmentStatusResponse;
import com.backintro.domain.treatmentstatus.model.aggregate.TreatmentStatus;
import com.backintro.domain.treatmentstatus.port.repository.TreatmentStatusRepository;

public class RegisterTreatmentStatusUseCase {

    private final TreatmentStatusRepository repository;

    public RegisterTreatmentStatusUseCase(
            TreatmentStatusRepository repository
    ) {
        this.repository = repository;
    }

    public TreatmentStatusResponse execute(
            RegisterTreatmentStatusCommand command
    ) {

        TreatmentStatus entity = TreatmentStatus.register(
                command.code(),
                command.name(),
                command.description()
        );

        TreatmentStatus saved =
                repository.save(entity);

        return new TreatmentStatusResponse(
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