package com.backintro.application.medicationroute.usecase;

import com.backintro.application.medicationroute.dto.MedicationRouteResponse;
import com.backintro.application.medicationroute.exception.MedicationRouteNotFoundApplicationException;
import com.backintro.domain.medicationroute.model.valueobject.MedicationRouteId;
import com.backintro.domain.medicationroute.port.repository.MedicationRouteRepository;

public class GetMedicationRouteByIdUseCase {

    private final MedicationRouteRepository repository;

    public GetMedicationRouteByIdUseCase(
            MedicationRouteRepository repository
    ) {
        this.repository = repository;
    }

    public MedicationRouteResponse execute(
            MedicationRouteId id
    ) {

        var entity =
                repository.findById(id)
                        .orElseThrow(() ->
                                new MedicationRouteNotFoundApplicationException(
                                        id.value().toString()
                                )
                        );

        return new MedicationRouteResponse(
                entity.id().value(),
                entity.code(),
                entity.name(),
                entity.active(),
                null,
                null
        );
    }
}