package com.backintro.infrastructure.credential.adapters.out.persistence.repositories;

import com.backintro.domain.credential.model.aggregate.Credential;
import com.backintro.domain.credential.model.valueobject.CredentialId;
import com.backintro.domain.credential.port.CredentialRepositoryPort;
import com.backintro.infrastructure.credential.adapters.out.persistence.entity.CredentialJpaEntity;
import com.backintro.infrastructure.credential.adapters.out.persistence.mappers.CredentialPersistenceMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class CredentialRepositoryAdapter implements CredentialRepositoryPort {

    private final CredentialJpaRepository jpaRepository;
    private final CredentialPersistenceMapper mapper;

    public CredentialRepositoryAdapter(CredentialJpaRepository jpaRepository, CredentialPersistenceMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Credential save(Credential credential) {
        CredentialJpaEntity entity = mapper.toEntity(credential);
        CredentialJpaEntity savedEntity = jpaRepository.save(entity);
        return mapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Credential> findById(CredentialId id) {
        return jpaRepository.findById(id.value())
                .map(mapper::toDomain);
    }

    @Override
    public Optional<Credential> findByUsername(String username) {
        return jpaRepository.findByUsername(username)
                .map(mapper::toDomain);
    }

    @Override
    public Optional<Credential> findByProfessionalId(UUID professionalId) {
        return jpaRepository.findByProfessionalId(professionalId)
                .map(mapper::toDomain);
    }
}
