package com.backintro.application.patientcontact.usecase;

import com.backintro.application.patientcontact.dto.PatientContactResponse;
import com.backintro.application.patientcontact.exception.PatientContactNotFoundApplicationException;
import com.backintro.domain.patientcontact.model.valueobject.PatientContactId;
import com.backintro.domain.patientcontact.port.repository.PatientContactRepository;
import com.backintro.domain.patient.port.repository.PatientRepository;
import com.backintro.domain.relationshiptype.port.repository.RelationshipTypeRepository;

public class GetPatientContactByIdUseCase {
    private final PatientContactRepository repository;
    private final PatientRepository patientRepository;
    private final RelationshipTypeRepository relationshipTypeRepository;

    public GetPatientContactByIdUseCase(
            PatientContactRepository repository,
            PatientRepository patientRepository,
            RelationshipTypeRepository relationshipTypeRepository
    ) {
        this.repository = repository;
        this.patientRepository = patientRepository;
        this.relationshipTypeRepository = relationshipTypeRepository;
    }

    public PatientContactResponse execute(PatientContactId id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new PatientContactNotFoundApplicationException(id.value().toString()));
        return new PatientContactResponse(
                entity.id().value(),
                entity.contactId(),
                entity.patientId(),
                patientRepository.findById(new com.backintro.domain.patient.model.valueobject.PatientId(entity.patientId())).map(c -> c.firstName() + " " + c.lastName()).orElse(null),
                entity.primaryContact(),
                entity.emergencyContact(),
                entity.relationshipTypeId(),
                entity.relationshipTypeId() != null ? relationshipTypeRepository.findById(new com.backintro.domain.relationshiptype.model.valueobject.RelationshipTypeId(entity.relationshipTypeId())).map(c -> c.description()).orElse(null) : null
        );
    }
}