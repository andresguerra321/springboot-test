package com.backintro.infrastructure.clinicalrecordstatus.adapters.out.persistence.mappers;

import com.backintro.domain.clinicalrecordstatus.model.aggregate.ClinicalRecordStatus;
import com.backintro.domain.clinicalrecordstatus.model.valueobject.ClinicalRecordStatusId;
import com.backintro.infrastructure.clinicalrecordstatus.adapters.out.persistence.entity.ClinicalRecordStatusJpaEntity;

public class ClinicalRecordStatusPersistenceMapper {

    public ClinicalRecordStatusJpaEntity toJpa(ClinicalRecordStatus domain) {

        if (domain == null) {
            return null;
        }

        ClinicalRecordStatusJpaEntity jpa = new ClinicalRecordStatusJpaEntity();

        jpa.setId(domain.id().value());
        jpa.setCode(domain.code());
        jpa.setName(domain.name());
        jpa.setActive(domain.active());

        return jpa;
    }

    public ClinicalRecordStatus toDomain(ClinicalRecordStatusJpaEntity jpa) {

        if (jpa == null) {
            return null;
        }

        return ClinicalRecordStatus.restore(
                new ClinicalRecordStatusId(jpa.getId()),
                jpa.getCode(),
                jpa.getName(),
                jpa.isActive()
        );
    }
}