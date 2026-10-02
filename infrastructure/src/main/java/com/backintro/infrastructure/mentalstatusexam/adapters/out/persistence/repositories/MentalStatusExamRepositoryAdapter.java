package com.backintro.infrastructure.mentalstatusexam.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.mentalstatusexam.model.aggregate.MentalStatusExam;
import com.backintro.domain.mentalstatusexam.model.valueobject.MentalStatusExamId;
import com.backintro.domain.mentalstatusexam.port.repository.MentalStatusExamRepository;
import com.backintro.infrastructure.mentalstatusexam.adapters.out.persistence.entity.MentalStatusExamJpaEntity;
import com.backintro.infrastructure.mentalstatusexam.adapters.out.persistence.mappers.MentalStatusExamPersistenceMapper;

public class MentalStatusExamRepositoryAdapter implements MentalStatusExamRepository {
    private final MentalStatusExamJpaRepository jpaRepository;
    private final MentalStatusExamPersistenceMapper mapper;

    public MentalStatusExamRepositoryAdapter(MentalStatusExamJpaRepository jpaRepository, MentalStatusExamPersistenceMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public MentalStatusExam save(MentalStatusExam entity) {
        MentalStatusExamJpaEntity jpaEntity = mapper.toJpa(entity);
        MentalStatusExamJpaEntity saved = jpaRepository.save(jpaEntity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<MentalStatusExam> findById(MentalStatusExamId id) {
        return jpaRepository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<MentalStatusExam> findAll() {
        return jpaRepository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(MentalStatusExam entity) {
        jpaRepository.deleteById(entity.id().value());
    }
}