package com.backintro.infrastructure.professional.adapters.out.persistence.mappers;

import com.backintro.domain.professional.model.aggregate.Professional;
import com.backintro.domain.professional.model.valueobject.ProfessionalId;
import com.backintro.infrastructure.professional.adapters.out.persistence.entity.ProfessionalJpaEntity;

public class ProfessionalPersistenceMapper {

    public ProfessionalJpaEntity toJpa(Professional domain) {
        if (domain == null) return null;
        ProfessionalJpaEntity jpa = new ProfessionalJpaEntity();
        jpa.setId(domain.id().value());
        jpa.setDocumentTypeId(domain.documentTypeId());
        jpa.setDocumentNumber(domain.documentNumber());
        jpa.setFirstName(domain.firstName());
        jpa.setLastName(domain.lastName());
        jpa.setProfessionalTypeId(domain.professionalTypeId());
        jpa.setLicenseNumber(domain.licenseNumber());
        jpa.setCityId(domain.cityId());
        jpa.setActive(domain.active());
        return jpa;
    }

    public Professional toDomain(ProfessionalJpaEntity jpa) {
        if (jpa == null) return null;
        return Professional.restore(
                new ProfessionalId(jpa.getId()),
                jpa.getDocumentTypeId(),
                jpa.getDocumentNumber(),
                jpa.getFirstName(),
                jpa.getLastName(),
                jpa.getProfessionalTypeId(),
                jpa.getLicenseNumber(),
                jpa.getCityId(),
                jpa.isActive()
        );
    }
}