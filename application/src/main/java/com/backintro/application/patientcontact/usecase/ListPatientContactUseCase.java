package com.backintro.application.patientcontact.usecase;

import java.util.List;

import com.backintro.application.patientcontact.dto.PatientContactResponse;
import com.backintro.domain.patientcontact.port.repository.PatientContactRepository;
import com.backintro.domain.patient.port.repository.PatientRepository;
import com.backintro.domain.relationshiptype.port.repository.RelationshipTypeRepository;

public class ListPatientContactUseCase {
    private final PatientContactRepository repository;
    private final PatientRepository patientRepository;
    private final RelationshipTypeRepository relationshipTypeRepository;

    public ListPatientContactUseCase(
            PatientContactRepository repository,
            PatientRepository patientRepository,
            RelationshipTypeRepository relationshipTypeRepository
    ) {
        this.repository = repository;
        this.patientRepository = patientRepository;
        this.relationshipTypeRepository = relationshipTypeRepository;
    }

    public List<PatientContactResponse> execute() {
        return repository.findAll()
                .stream()
                .map(entity -> new PatientContactResponse(
                entity.id().value(),
                entity.contactId(),
                entity.patientId(),
                patientRepository.findById(new com.backintro.domain.patient.model.valueobject.PatientId(entity.patientId())).map(c -> c.firstName() + " " + c.lastName()).orElse(null),
                entity.primaryContact(),
                entity.emergencyContact(),
                entity.relationshipTypeId(),
                entity.relationshipTypeId() != null ? relationshipTypeRepository.findById(new com.backintro.domain.relationshiptype.model.valueobject.RelationshipTypeId(entity.relationshipTypeId())).map(c -> c.description()).orElse(null) : null
                ))
                .toList();
    }
}