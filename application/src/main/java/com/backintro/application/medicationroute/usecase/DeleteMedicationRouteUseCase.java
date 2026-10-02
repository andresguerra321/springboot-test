package com.backintro.application.medicationroute.usecase;

import java.time.LocalDateTime;

import com.backintro.application.medicationroute.exception.MedicationRouteNotFoundApplicationException;
import com.backintro.domain.medicationroute.event.MedicationRouteDeletedEvent;
import com.backintro.domain.medicationroute.model.valueobject.MedicationRouteId;
import com.backintro.domain.medicationroute.port.repository.MedicationRouteRepository;

public class DeleteMedicationRouteUseCase {

    private final MedicationRouteRepository repository;

    public DeleteMedicationRouteUseCase(
            MedicationRouteRepository repository
    ) {
        this.repository = repository;
    }

    public MedicationRouteDeletedEvent execute(
            MedicationRouteId id
    ) {

        var entity =
                repository.findById(id)
                        .orElseThrow(() ->
                                new MedicationRouteNotFoundApplicationException(
                                        id.value().toString()
                                )
                        );

        repository.delete(entity);

        return new MedicationRouteDeletedEvent(
                id,
                LocalDateTime.now()
        );
    }
}