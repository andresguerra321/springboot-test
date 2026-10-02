package com.backintro.infrastructure.treatmentgoal.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.treatmentgoal.model.aggregate.TreatmentGoal;
import com.backintro.domain.treatmentgoal.model.valueobject.TreatmentGoalId;
import com.backintro.domain.treatmentgoal.port.repository.TreatmentGoalRepository;
import com.backintro.infrastructure.treatmentgoal.adapters.out.persistence.entity.TreatmentGoalJpaEntity;
import com.backintro.infrastructure.treatmentgoal.adapters.out.persistence.mappers.TreatmentGoalPersistenceMapper;

public class TreatmentGoalRepositoryAdapter implements TreatmentGoalRepository {
    private final TreatmentGoalJpaRepository jpaRepository;
    private final TreatmentGoalPersistenceMapper mapper;

    public TreatmentGoalRepositoryAdapter(TreatmentGoalJpaRepository jpaRepository, TreatmentGoalPersistenceMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public TreatmentGoal save(TreatmentGoal entity) {
        TreatmentGoalJpaEntity jpaEntity = mapper.toJpa(entity);
        TreatmentGoalJpaEntity saved = jpaRepository.save(jpaEntity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<TreatmentGoal> findById(TreatmentGoalId id) {
        return jpaRepository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<TreatmentGoal> findAll() {
        return jpaRepository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(TreatmentGoal entity) {
        jpaRepository.deleteById(entity.id().value());
    }
}