package com.backintro.application.patientallergy.usecase;

import com.backintro.application.patientallergy.command.UpdatePatientAllergyCommand;
import com.backintro.application.patientallergy.dto.PatientAllergyResponse;
import com.backintro.application.patientallergy.exception.PatientAllergyNotFoundApplicationException;
import com.backintro.domain.patientallergy.port.repository.PatientAllergyRepository;
import com.backintro.domain.patient.port.repository.PatientRepository;

public class UpdatePatientAllergyUseCase {
    private final PatientAllergyRepository repository;
    private final PatientRepository patientRepository;

    public UpdatePatientAllergyUseCase(
            PatientAllergyRepository repository,
            PatientRepository patientRepository
    ) {
        this.repository = repository;
        this.patientRepository = patientRepository;
    }

    public PatientAllergyResponse execute(UpdatePatientAllergyCommand command) {
        var entity = repository.findById(command.id())
                .orElseThrow(() -> new PatientAllergyNotFoundApplicationException(command.id().value().toString()));

        entity.update(
                command.patientId(),
                command.substance(),
                command.reaction(),
                command.severity(),
                command.recordedAt(),
                command.recordedBy()
        );

        var updated = repository.save(entity);
        return new PatientAllergyResponse(
                updated.id().value(),
                updated.patientId(),
                patientRepository.findById(new com.backintro.domain.patient.model.valueobject.PatientId(updated.patientId())).map(c -> c.firstName() + " " + c.lastName()).orElse(null),
                updated.substance(),
                updated.reaction(),
                updated.severity(),
                updated.active(),
                updated.recordedAt(),
                updated.recordedBy(),
                null,
                null
        );
    }
}