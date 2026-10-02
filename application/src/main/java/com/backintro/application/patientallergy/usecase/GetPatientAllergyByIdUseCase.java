package com.backintro.application.patientallergy.usecase;

import com.backintro.application.patientallergy.dto.PatientAllergyResponse;
import com.backintro.application.patientallergy.exception.PatientAllergyNotFoundApplicationException;
import com.backintro.domain.patientallergy.model.valueobject.PatientAllergyId;
import com.backintro.domain.patientallergy.port.repository.PatientAllergyRepository;
import com.backintro.domain.patient.port.repository.PatientRepository;

public class GetPatientAllergyByIdUseCase {
    private final PatientAllergyRepository repository;
    private final PatientRepository patientRepository;

    public GetPatientAllergyByIdUseCase(
            PatientAllergyRepository repository,
            PatientRepository patientRepository
    ) {
        this.repository = repository;
        this.patientRepository = patientRepository;
    }

    public PatientAllergyResponse execute(PatientAllergyId id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new PatientAllergyNotFoundApplicationException(id.value().toString()));
        return new PatientAllergyResponse(
                entity.id().value(),
                entity.patientId(),
                patientRepository.findById(new com.backintro.domain.patient.model.valueobject.PatientId(entity.patientId())).map(c -> c.firstName() + " " + c.lastName()).orElse(null),
                entity.substance(),
                entity.reaction(),
                entity.severity(),
                entity.active(),
                entity.recordedAt(),
                entity.recordedBy(),
                null,
                null
        );
    }
}