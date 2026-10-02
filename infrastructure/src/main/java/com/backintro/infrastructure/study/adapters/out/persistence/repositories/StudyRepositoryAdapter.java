package com.backintro.infrastructure.study.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.study.model.aggregate.Study;
import com.backintro.domain.study.model.valueobject.StudyId;
import com.backintro.domain.study.port.repository.StudyRepository;
import com.backintro.infrastructure.study.adapters.out.persistence.entity.StudyJpaEntity;
import com.backintro.infrastructure.study.adapters.out.persistence.mappers.StudyPersistenceMapper;

public class StudyRepositoryAdapter implements StudyRepository {

    private final StudyJpaRepository jpaRepository;
    private final StudyPersistenceMapper mapper;

    public StudyRepositoryAdapter(
            StudyJpaRepository jpaRepository,
            StudyPersistenceMapper mapper
    ) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Study save(Study entity) {
        StudyJpaEntity jpaEntity = mapper.toJpa(entity);
        StudyJpaEntity saved = jpaRepository.save(jpaEntity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<Study> findById(StudyId id) {
        return jpaRepository.findById(id.value())
                .map(mapper::toDomain);
    }

    @Override
    public List<Study> findAll() {
        return jpaRepository.findAll()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public void delete(Study entity) {
        jpaRepository.deleteById(entity.id().value());
    }
}