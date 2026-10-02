package com.backintro.infrastructure.patientcontact.adapters.out.persistence.mappers;

import com.backintro.domain.patientcontact.model.aggregate.PatientContact;
import com.backintro.domain.patientcontact.model.valueobject.PatientContactId;
import com.backintro.infrastructure.patientcontact.adapters.out.persistence.entity.PatientContactJpaEntity;

public class PatientContactPersistenceMapper {

    public PatientContactJpaEntity toJpa(PatientContact domain) {
        if (domain == null) return null;
        PatientContactJpaEntity jpa = new PatientContactJpaEntity();
        jpa.setId(domain.id().value());
        jpa.setContactId(domain.contactId());
        jpa.setPatientId(domain.patientId());
        jpa.setPrimaryContact(domain.primaryContact());
        jpa.setEmergencyContact(domain.emergencyContact());
        jpa.setRelationshipTypeId(domain.relationshipTypeId());
        return jpa;
    }

    public PatientContact toDomain(PatientContactJpaEntity jpa) {
        if (jpa == null) return null;
        return PatientContact.restore(
                new PatientContactId(jpa.getId()),
                jpa.getContactId(),
                jpa.getPatientId(),
                jpa.isPrimaryContact(),
                jpa.isEmergencyContact(),
                jpa.getRelationshipTypeId()
        );
    }
}