package com.backintro.infrastructure.relationshiptype.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.relationshiptype.model.aggregate.RelationshipType;
import com.backintro.domain.relationshiptype.model.valueobject.RelationshipTypeId;
import com.backintro.domain.relationshiptype.port.repository.RelationshipTypeRepository;
import com.backintro.infrastructure.relationshiptype.adapters.out.persistence.entity.RelationshipTypeJpaEntity;
import com.backintro.infrastructure.relationshiptype.adapters.out.persistence.mappers.RelationshipTypePersistenceMapper;

public class RelationshipTypeRepositoryAdapter implements RelationshipTypeRepository {

    private final RelationshipTypeJpaRepository jpaRepository;
    private final RelationshipTypePersistenceMapper mapper;

    public RelationshipTypeRepositoryAdapter(
            RelationshipTypeJpaRepository jpaRepository,
            RelationshipTypePersistenceMapper mapper
    ) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public RelationshipType save(RelationshipType entity) {
        RelationshipTypeJpaEntity jpaEntity = mapper.toJpa(entity);
        RelationshipTypeJpaEntity saved = jpaRepository.save(jpaEntity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<RelationshipType> findById(RelationshipTypeId id) {
        return jpaRepository.findById(id.value())
                .map(mapper::toDomain);
    }

    @Override
    public List<RelationshipType> findAll() {
        return jpaRepository.findAll()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public void delete(RelationshipType entity) {
        jpaRepository.deleteById(entity.id().value());
    }
}