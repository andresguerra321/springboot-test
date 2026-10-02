package com.backintro.application.patientallergy.usecase;

import java.time.LocalDateTime;

import com.backintro.application.patientallergy.exception.PatientAllergyNotFoundApplicationException;
import com.backintro.domain.patientallergy.event.PatientAllergyDeletedEvent;
import com.backintro.domain.patientallergy.model.valueobject.PatientAllergyId;
import com.backintro.domain.patientallergy.port.repository.PatientAllergyRepository;

public class DeletePatientAllergyUseCase {
    private final PatientAllergyRepository repository;

    public DeletePatientAllergyUseCase(PatientAllergyRepository repository) {
        this.repository = repository;
    }

    public PatientAllergyDeletedEvent execute(PatientAllergyId id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new PatientAllergyNotFoundApplicationException(id.value().toString()));
        repository.delete(entity);
        return new PatientAllergyDeletedEvent(id, LocalDateTime.now());
    }
}