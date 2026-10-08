package com.backintro.infrastructure.credential.adapters.out.persistence.mappers;

import com.backintro.domain.credential.model.aggregate.Credential;
import com.backintro.domain.credential.model.valueobject.CredentialId;
import com.backintro.domain.credential.model.valueobject.Role;
import com.backintro.infrastructure.credential.adapters.out.persistence.entity.CredentialJpaEntity;
import org.springframework.stereotype.Component;

@Component
public class CredentialPersistenceMapper {

    public Credential toDomain(CredentialJpaEntity entity) {
        if (entity == null) {
            return null;
        }

        return Credential.restore(
            new CredentialId(entity.getId()),
            entity.getProfessionalId(),
            entity.getUsername(),
            entity.getPasswordHash(),
            Role.valueOf(entity.getRole()),
            entity.isEnabled(),
            entity.getCreatedAt(),
            entity.getUpdatedAt()
        );
    }

    public CredentialJpaEntity toEntity(Credential domain) {
        if (domain == null) {
            return null;
        }

        return new CredentialJpaEntity(
            domain.getId().value(),
            domain.getProfessionalId(),
            domain.getUsername(),
            domain.getPasswordHash(),
            domain.getRole().name(),
            domain.isEnabled(),
            domain.getCreatedAt(),
            domain.getUpdatedAt()
        );
    }
}
