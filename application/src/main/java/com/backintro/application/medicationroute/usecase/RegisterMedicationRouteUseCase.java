package com.backintro.application.medicationroute.usecase;

import com.backintro.application.medicationroute.command.RegisterMedicationRouteCommand;
import com.backintro.application.medicationroute.dto.MedicationRouteResponse;
import com.backintro.domain.medicationroute.model.aggregate.MedicationRoute;
import com.backintro.domain.medicationroute.port.repository.MedicationRouteRepository;

public class RegisterMedicationRouteUseCase {

    private final MedicationRouteRepository repository;

    public RegisterMedicationRouteUseCase(
            MedicationRouteRepository repository
    ) {
        this.repository = repository;
    }

    public MedicationRouteResponse execute(
            RegisterMedicationRouteCommand command
    ) {

        MedicationRoute entity = MedicationRoute.register(
                command.code(),
                command.name()
        );

        MedicationRoute saved =
                repository.save(entity);

        return new MedicationRouteResponse(
                saved.id().value(),
                saved.code(),
                saved.name(),
                saved.active(),
                null,
                null
        );
    }
}