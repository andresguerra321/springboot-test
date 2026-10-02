package com.backintro.infrastructure.gender.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.gender.model.aggregate.Gender;
import com.backintro.domain.gender.model.valueobject.GenderId;
import com.backintro.domain.gender.port.repository.GenderRepository;
import com.backintro.infrastructure.gender.adapters.out.persistence.entity.GenderJpaEntity;
import com.backintro.infrastructure.gender.adapters.out.persistence.mappers.GenderPersistenceMapper;

public class GenderRepositoryAdapter implements GenderRepository {

    private final GenderJpaRepository jpaRepository;
    private final GenderPersistenceMapper mapper;

    public GenderRepositoryAdapter(
            GenderJpaRepository jpaRepository,
            GenderPersistenceMapper mapper
    ) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Gender save(Gender entity) {
        GenderJpaEntity jpaEntity = mapper.toJpa(entity);
        GenderJpaEntity saved = jpaRepository.save(jpaEntity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<Gender> findById(GenderId id) {
        return jpaRepository.findById(id.value())
                .map(mapper::toDomain);
    }

    @Override
    public List<Gender> findAll() {
        return jpaRepository.findAll()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public void delete(Gender entity) {
        jpaRepository.deleteById(entity.id().value());
    }
}