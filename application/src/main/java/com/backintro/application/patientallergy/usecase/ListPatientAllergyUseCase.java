package com.backintro.application.patientallergy.usecase;

import java.util.List;

import com.backintro.application.patientallergy.dto.PatientAllergyResponse;
import com.backintro.domain.patientallergy.port.repository.PatientAllergyRepository;
import com.backintro.domain.patient.port.repository.PatientRepository;

public class ListPatientAllergyUseCase {
    private final PatientAllergyRepository repository;
    private final PatientRepository patientRepository;

    public ListPatientAllergyUseCase(
            PatientAllergyRepository repository,
            PatientRepository patientRepository
    ) {
        this.repository = repository;
        this.patientRepository = patientRepository;
    }

    public List<PatientAllergyResponse> execute() {
        return repository.findAll()
                .stream()
                .map(entity -> new PatientAllergyResponse(
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
                ))
                .toList();
    }
}