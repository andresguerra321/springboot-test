package com.backintro.infrastructure.riskassessment.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.riskassessment.model.aggregate.RiskAssessment;
import com.backintro.domain.riskassessment.model.valueobject.RiskAssessmentId;
import com.backintro.domain.riskassessment.port.repository.RiskAssessmentRepository;
import com.backintro.infrastructure.riskassessment.adapters.out.persistence.entity.RiskAssessmentJpaEntity;
import com.backintro.infrastructure.riskassessment.adapters.out.persistence.mappers.RiskAssessmentPersistenceMapper;

public class RiskAssessmentRepositoryAdapter implements RiskAssessmentRepository {
    private final RiskAssessmentJpaRepository jpaRepository;
    private final RiskAssessmentPersistenceMapper mapper;

    public RiskAssessmentRepositoryAdapter(RiskAssessmentJpaRepository jpaRepository, RiskAssessmentPersistenceMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public RiskAssessment save(RiskAssessment entity) {
        RiskAssessmentJpaEntity jpaEntity = mapper.toJpa(entity);
        RiskAssessmentJpaEntity saved = jpaRepository.save(jpaEntity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<RiskAssessment> findById(RiskAssessmentId id) {
        return jpaRepository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<RiskAssessment> findAll() {
        return jpaRepository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(RiskAssessment entity) {
        jpaRepository.deleteById(entity.id().value());
    }
}