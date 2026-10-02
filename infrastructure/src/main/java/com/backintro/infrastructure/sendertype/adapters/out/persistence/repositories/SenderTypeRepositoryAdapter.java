package com.backintro.infrastructure.sendertype.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.sendertype.model.aggregate.SenderType;
import com.backintro.domain.sendertype.model.valueobject.SenderTypeId;
import com.backintro.domain.sendertype.port.repository.SenderTypeRepository;
import com.backintro.infrastructure.sendertype.adapters.out.persistence.entity.SenderTypeJpaEntity;
import com.backintro.infrastructure.sendertype.adapters.out.persistence.mappers.SenderTypePersistenceMapper;

public class SenderTypeRepositoryAdapter implements SenderTypeRepository {
    private final SenderTypeJpaRepository jpaRepository;
    private final SenderTypePersistenceMapper mapper;

    public SenderTypeRepositoryAdapter(SenderTypeJpaRepository jpaRepository, SenderTypePersistenceMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public SenderType save(SenderType entity) {
        SenderTypeJpaEntity jpaEntity = mapper.toJpa(entity);
        SenderTypeJpaEntity saved = jpaRepository.save(jpaEntity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<SenderType> findById(SenderTypeId id) {
        return jpaRepository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<SenderType> findAll() {
        return jpaRepository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(SenderType entity) {
        jpaRepository.deleteById(entity.id().value());
    }
}