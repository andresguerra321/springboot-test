package com.backintro.application.patientallergy.usecase;

import com.backintro.application.patientallergy.command.RegisterPatientAllergyCommand;
import com.backintro.application.patientallergy.dto.PatientAllergyResponse;
import com.backintro.domain.patientallergy.model.aggregate.PatientAllergy;
import com.backintro.domain.patientallergy.port.repository.PatientAllergyRepository;
import com.backintro.domain.patient.port.repository.PatientRepository;

public class RegisterPatientAllergyUseCase {
    private final PatientAllergyRepository repository;
    private final PatientRepository patientRepository;

    public RegisterPatientAllergyUseCase(
            PatientAllergyRepository repository,
            PatientRepository patientRepository
    ) {
        this.repository = repository;
        this.patientRepository = patientRepository;
    }

    public PatientAllergyResponse execute(RegisterPatientAllergyCommand command) {
        PatientAllergy entity = PatientAllergy.register(
                command.patientId(),
                command.substance(),
                command.reaction(),
                command.severity(),
                command.recordedAt(),
                command.recordedBy()
        );
        PatientAllergy saved = repository.save(entity);
        return new PatientAllergyResponse(
                saved.id().value(),
                saved.patientId(),
                patientRepository.findById(new com.backintro.domain.patient.model.valueobject.PatientId(saved.patientId())).map(c -> c.firstName() + " " + c.lastName()).orElse(null),
                saved.substance(),
                saved.reaction(),
                saved.severity(),
                saved.active(),
                saved.recordedAt(),
                saved.recordedBy(),
                null,
                null
        );
    }
}