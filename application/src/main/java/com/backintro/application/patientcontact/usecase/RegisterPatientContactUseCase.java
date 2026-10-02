package com.backintro.application.patientcontact.usecase;

import com.backintro.application.patientcontact.command.RegisterPatientContactCommand;
import com.backintro.application.patientcontact.dto.PatientContactResponse;
import com.backintro.domain.patientcontact.model.aggregate.PatientContact;
import com.backintro.domain.patientcontact.port.repository.PatientContactRepository;
import com.backintro.domain.patient.port.repository.PatientRepository;
import com.backintro.domain.relationshiptype.port.repository.RelationshipTypeRepository;

public class RegisterPatientContactUseCase {
    private final PatientContactRepository repository;
    private final PatientRepository patientRepository;
    private final RelationshipTypeRepository relationshipTypeRepository;

    public RegisterPatientContactUseCase(
            PatientContactRepository repository,
            PatientRepository patientRepository,
            RelationshipTypeRepository relationshipTypeRepository
    ) {
        this.repository = repository;
        this.patientRepository = patientRepository;
        this.relationshipTypeRepository = relationshipTypeRepository;
    }

    public PatientContactResponse execute(RegisterPatientContactCommand command) {
        PatientContact entity = PatientContact.register(
                command.contactId(),
                command.patientId(),
                command.primaryContact(),
                command.emergencyContact(),
                command.relationshipTypeId()
        );
        PatientContact saved = repository.save(entity);
        return new PatientContactResponse(
                saved.id().value(),
                saved.contactId(),
                saved.patientId(),
                patientRepository.findById(new com.backintro.domain.patient.model.valueobject.PatientId(saved.patientId())).map(c -> c.firstName() + " " + c.lastName()).orElse(null),
                saved.primaryContact(),
                saved.emergencyContact(),
                saved.relationshipTypeId(),
                saved.relationshipTypeId() != null ? relationshipTypeRepository.findById(new com.backintro.domain.relationshiptype.model.valueobject.RelationshipTypeId(saved.relationshipTypeId())).map(c -> c.description()).orElse(null) : null
        );
    }
}