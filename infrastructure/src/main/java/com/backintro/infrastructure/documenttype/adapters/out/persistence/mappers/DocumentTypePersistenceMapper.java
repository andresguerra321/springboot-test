package com.backintro.infrastructure.documenttype.adapters.out.persistence.mappers;

import com.backintro.domain.documenttype.model.aggregate.DocumentType;
import com.backintro.domain.documenttype.model.valueobject.DocumentTypeId;
import com.backintro.infrastructure.documenttype.adapters.out.persistence.entity.DocumentTypeJpaEntity;

public class DocumentTypePersistenceMapper {

    public DocumentTypeJpaEntity toJpa(DocumentType domain) {

        if (domain == null) {
            return null;
        }

        DocumentTypeJpaEntity jpa = new DocumentTypeJpaEntity();

        jpa.setId(domain.id().value());
        jpa.setCode(domain.code());
        jpa.setName(domain.name());
        jpa.setActive(domain.active());

        return jpa;
    }

    public DocumentType toDomain(DocumentTypeJpaEntity jpa) {

        if (jpa == null) {
            return null;
        }

        return DocumentType.restore(
                new DocumentTypeId(jpa.getId()),
                jpa.getCode(),
                jpa.getName(),
                jpa.isActive()
        );
    }
}