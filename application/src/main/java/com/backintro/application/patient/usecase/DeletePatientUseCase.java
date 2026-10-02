package com.backintro.application.patient.usecase;

import java.time.LocalDateTime;

import com.backintro.application.patient.exception.PatientNotFoundApplicationException;
import com.backintro.domain.patient.event.PatientDeletedEvent;
import com.backintro.domain.patient.model.valueobject.PatientId;
import com.backintro.domain.patient.port.repository.PatientRepository;

public class DeletePatientUseCase {
    private final PatientRepository repository;

    public DeletePatientUseCase(PatientRepository repository) {
        this.repository = repository;
    }

    public PatientDeletedEvent execute(PatientId id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new PatientNotFoundApplicationException(id.value().toString()));
        repository.delete(entity);
        return new PatientDeletedEvent(id, LocalDateTime.now());
    }
}