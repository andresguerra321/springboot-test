package com.backintro.application.medicationroute.usecase;

import com.backintro.application.medicationroute.command.UpdateMedicationRouteCommand;
import com.backintro.application.medicationroute.dto.MedicationRouteResponse;
import com.backintro.application.medicationroute.exception.MedicationRouteNotFoundApplicationException;
import com.backintro.domain.medicationroute.port.repository.MedicationRouteRepository;

public class UpdateMedicationRouteUseCase {

    private final MedicationRouteRepository repository;

    public UpdateMedicationRouteUseCase(
            MedicationRouteRepository repository
    ) {
        this.repository = repository;
    }

    public MedicationRouteResponse execute(
            UpdateMedicationRouteCommand command
    ) {

        var entity =
                repository.findById(command.id())
                        .orElseThrow(() ->
                                new MedicationRouteNotFoundApplicationException(
                                        command.id()
                                                .value()
                                                .toString()
                                )
                        );

        entity.update(
                command.code(),
                command.name()
        );

        var updated =
                repository.save(entity);

        return new MedicationRouteResponse(
                updated.id().value(),
                updated.code(),
                updated.name(),
                updated.active(),
                null,
                null
        );
    }
}