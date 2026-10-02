package com.backintro.application.patientcontact.usecase;

import com.backintro.application.patientcontact.command.UpdatePatientContactCommand;
import com.backintro.application.patientcontact.dto.PatientContactResponse;
import com.backintro.application.patientcontact.exception.PatientContactNotFoundApplicationException;
import com.backintro.domain.patientcontact.port.repository.PatientContactRepository;
import com.backintro.domain.patient.port.repository.PatientRepository;
import com.backintro.domain.relationshiptype.port.repository.RelationshipTypeRepository;

public class UpdatePatientContactUseCase {
    private final PatientContactRepository repository;
    private final PatientRepository patientRepository;
    private final RelationshipTypeRepository relationshipTypeRepository;

    public UpdatePatientContactUseCase(
            PatientContactRepository repository,
            PatientRepository patientRepository,
            RelationshipTypeRepository relationshipTypeRepository
    ) {
        this.repository = repository;
        this.patientRepository = patientRepository;
        this.relationshipTypeRepository = relationshipTypeRepository;
    }

    public PatientContactResponse execute(UpdatePatientContactCommand command) {
        var entity = repository.findById(command.id())
                .orElseThrow(() -> new PatientContactNotFoundApplicationException(command.id().value().toString()));

        entity.update(
                command.contactId(),
                command.patientId(),
                command.primaryContact(),
                command.emergencyContact(),
                command.relationshipTypeId()
        );

        var updated = repository.save(entity);
        return new PatientContactResponse(
                updated.id().value(),
                updated.contactId(),
                updated.patientId(),
                patientRepository.findById(new com.backintro.domain.patient.model.valueobject.PatientId(updated.patientId())).map(c -> c.firstName() + " " + c.lastName()).orElse(null),
                updated.primaryContact(),
                updated.emergencyContact(),
                updated.relationshipTypeId(),
                updated.relationshipTypeId() != null ? relationshipTypeRepository.findById(new com.backintro.domain.relationshiptype.model.valueobject.RelationshipTypeId(updated.relationshipTypeId())).map(c -> c.description()).orElse(null) : null
        );
    }
}