package com.backintro.infrastructure.escalationstatus.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.escalationstatus.model.aggregate.EscalationStatus;
import com.backintro.domain.escalationstatus.model.valueobject.EscalationStatusId;
import com.backintro.domain.escalationstatus.port.repository.EscalationStatusRepository;
import com.backintro.infrastructure.escalationstatus.adapters.out.persistence.entity.EscalationStatusJpaEntity;
import com.backintro.infrastructure.escalationstatus.adapters.out.persistence.mappers.EscalationStatusPersistenceMapper;

public class EscalationStatusRepositoryAdapter implements EscalationStatusRepository {
    private final EscalationStatusJpaRepository jpaRepository;
    private final EscalationStatusPersistenceMapper mapper;

    public EscalationStatusRepositoryAdapter(EscalationStatusJpaRepository jpaRepository, EscalationStatusPersistenceMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public EscalationStatus save(EscalationStatus entity) {
        EscalationStatusJpaEntity jpaEntity = mapper.toJpa(entity);
        EscalationStatusJpaEntity saved = jpaRepository.save(jpaEntity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<EscalationStatus> findById(EscalationStatusId id) {
        return jpaRepository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<EscalationStatus> findAll() {
        return jpaRepository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(EscalationStatus entity) {
        jpaRepository.deleteById(entity.id().value());
    }
}