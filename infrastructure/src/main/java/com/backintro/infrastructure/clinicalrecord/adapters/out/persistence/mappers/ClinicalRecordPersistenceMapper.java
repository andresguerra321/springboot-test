package com.backintro.infrastructure.clinicalrecord.adapters.out.persistence.mappers;

import com.backintro.domain.clinicalrecord.model.aggregate.ClinicalRecord;
import com.backintro.domain.clinicalrecord.model.valueobject.ClinicalRecordId;
import com.backintro.infrastructure.clinicalrecord.adapters.out.persistence.entity.ClinicalRecordJpaEntity;

public class ClinicalRecordPersistenceMapper {

    public ClinicalRecordJpaEntity toJpa(ClinicalRecord domain) {
        if (domain == null) return null;
        ClinicalRecordJpaEntity jpa = new ClinicalRecordJpaEntity();
        jpa.setId(domain.id().value());
        jpa.setPatientId(domain.patientId());
        jpa.setCreationDate(domain.creationDate());
        jpa.setRecordNumber(domain.recordNumber());
        jpa.setOpenedAt(domain.openedAt());
        jpa.setClosedAt(domain.closedAt());
        jpa.setStatusId(domain.statusId());
        jpa.setCreatedBy(domain.createdBy());
        return jpa;
    }

    public ClinicalRecord toDomain(ClinicalRecordJpaEntity jpa) {
        if (jpa == null) return null;
        return ClinicalRecord.restore(
                new ClinicalRecordId(jpa.getId()),
                jpa.getPatientId(),
                jpa.getCreationDate(),
                jpa.getRecordNumber(),
                jpa.getOpenedAt(),
                jpa.getClosedAt(),
                jpa.getStatusId(),
                jpa.getCreatedBy()
        );
    }
}