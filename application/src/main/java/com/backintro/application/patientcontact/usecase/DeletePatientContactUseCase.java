package com.backintro.application.patientcontact.usecase;

import java.time.LocalDateTime;

import com.backintro.application.patientcontact.exception.PatientContactNotFoundApplicationException;
import com.backintro.domain.patientcontact.event.PatientContactDeletedEvent;
import com.backintro.domain.patientcontact.model.valueobject.PatientContactId;
import com.backintro.domain.patientcontact.port.repository.PatientContactRepository;

public class DeletePatientContactUseCase {
    private final PatientContactRepository repository;

    public DeletePatientContactUseCase(PatientContactRepository repository) {
        this.repository = repository;
    }

    public PatientContactDeletedEvent execute(PatientContactId id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new PatientContactNotFoundApplicationException(id.value().toString()));
        repository.delete(entity);
        return new PatientContactDeletedEvent(id, LocalDateTime.now());
    }
}