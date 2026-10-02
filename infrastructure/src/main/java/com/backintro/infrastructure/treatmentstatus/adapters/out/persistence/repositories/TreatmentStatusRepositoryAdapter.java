package com.backintro.infrastructure.treatmentstatus.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.treatmentstatus.model.aggregate.TreatmentStatus;
import com.backintro.domain.treatmentstatus.model.valueobject.TreatmentStatusId;
import com.backintro.domain.treatmentstatus.port.repository.TreatmentStatusRepository;
import com.backintro.infrastructure.treatmentstatus.adapters.out.persistence.entity.TreatmentStatusJpaEntity;
import com.backintro.infrastructure.treatmentstatus.adapters.out.persistence.mappers.TreatmentStatusPersistenceMapper;

public class TreatmentStatusRepositoryAdapter implements TreatmentStatusRepository {

    private final TreatmentStatusJpaRepository jpaRepository;
    private final TreatmentStatusPersistenceMapper mapper;

    public TreatmentStatusRepositoryAdapter(
            TreatmentStatusJpaRepository jpaRepository,
            TreatmentStatusPersistenceMapper mapper
    ) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public TreatmentStatus save(TreatmentStatus entity) {
        TreatmentStatusJpaEntity jpaEntity = mapper.toJpa(entity);
        TreatmentStatusJpaEntity saved = jpaRepository.save(jpaEntity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<TreatmentStatus> findById(TreatmentStatusId id) {
        return jpaRepository.findById(id.value())
                .map(mapper::toDomain);
    }

    @Override
    public List<TreatmentStatus> findAll() {
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
    public void delete(TreatmentStatus entity) {
        jpaRepository.deleteById(entity.id().value());
    }
}