package com.backintro.infrastructure.patient.adapters.out.persistence.mappers;

import com.backintro.domain.patient.model.aggregate.Patient;
import com.backintro.domain.patient.model.valueobject.PatientId;
import com.backintro.infrastructure.patient.adapters.out.persistence.entity.PatientJpaEntity;

public class PatientPersistenceMapper {

    public PatientJpaEntity toJpa(Patient domain) {
        if (domain == null) return null;
        PatientJpaEntity jpa = new PatientJpaEntity();
        jpa.setId(domain.id().value());
        jpa.setDocumentTypeId(domain.documentTypeId());
        jpa.setDocumentNumber(domain.documentNumber());
        jpa.setFirstName(domain.firstName());
        jpa.setMiddleName(domain.middleName());
        jpa.setLastName(domain.lastName());
        jpa.setSecondLastName(domain.secondLastName());
        jpa.setBirthDate(domain.birthDate());
        jpa.setBiologicalSexId(domain.biologicalSexId());
        jpa.setGenderIdentity(domain.genderIdentity());
        jpa.setEmail(domain.email());
        jpa.setPhone(domain.phone());
        jpa.setAddress(domain.address());
        jpa.setActive(domain.active());
        jpa.setCityId(domain.cityId());
        jpa.setCreatedBy(domain.createdBy());
        jpa.setUpdatedBy(domain.updatedBy());
        jpa.setCreatedAt(domain.createdAt());
        jpa.setUpdatedAt(domain.updatedAt());
        return jpa;
    }

    public Patient toDomain(PatientJpaEntity jpa) {
        if (jpa == null) return null;
        return Patient.restore(
                new PatientId(jpa.getId()),
                jpa.getDocumentTypeId(),
                jpa.getDocumentNumber(),
                jpa.getFirstName(),
                jpa.getMiddleName(),
                jpa.getLastName(),
                jpa.getSecondLastName(),
                jpa.getBirthDate(),
                jpa.getBiologicalSexId(),
                jpa.getGenderIdentity(),
                jpa.getEmail(),
                jpa.getPhone(),
                jpa.getAddress(),
                jpa.isActive(),
                jpa.getCityId(),
                jpa.getCreatedBy(),
                jpa.getUpdatedBy(),
                jpa.getCreatedAt(),
                jpa.getUpdatedAt()
        );
    }
}