package com.backintro.infrastructure.consenttype.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.consenttype.model.aggregate.ConsentType;
import com.backintro.domain.consenttype.model.valueobject.ConsentTypeId;
import com.backintro.domain.consenttype.port.repository.ConsentTypeRepository;
import com.backintro.infrastructure.consenttype.adapters.out.persistence.entity.ConsentTypeJpaEntity;
import com.backintro.infrastructure.consenttype.adapters.out.persistence.mappers.ConsentTypePersistenceMapper;

public class ConsentTypeRepositoryAdapter implements ConsentTypeRepository {

    private final ConsentTypeJpaRepository jpaRepository;
    private final ConsentTypePersistenceMapper mapper;

    public ConsentTypeRepositoryAdapter(
            ConsentTypeJpaRepository jpaRepository,
            ConsentTypePersistenceMapper mapper
    ) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public ConsentType save(ConsentType entity) {
        ConsentTypeJpaEntity jpaEntity = mapper.toJpa(entity);
        ConsentTypeJpaEntity saved = jpaRepository.save(jpaEntity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<ConsentType> findById(ConsentTypeId id) {
        return jpaRepository.findById(id.value())
                .map(mapper::toDomain);
    }

    @Override
    public List<ConsentType> findAll() {
        return jpaRepository.findAll()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public boolean existsByCode(String code) {
        return jpaRepository.existsByCode(code);
    }
    @Override
    public void delete(ConsentType entity) {
        jpaRepository.deleteById(entity.id().value());
    }
}