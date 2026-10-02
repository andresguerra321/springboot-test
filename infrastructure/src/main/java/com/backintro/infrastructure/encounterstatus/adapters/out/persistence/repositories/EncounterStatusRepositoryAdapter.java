package com.backintro.infrastructure.encounterstatus.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.encounterstatus.model.aggregate.EncounterStatus;
import com.backintro.domain.encounterstatus.model.valueobject.EncounterStatusId;
import com.backintro.domain.encounterstatus.port.repository.EncounterStatusRepository;
import com.backintro.infrastructure.encounterstatus.adapters.out.persistence.entity.EncounterStatusJpaEntity;
import com.backintro.infrastructure.encounterstatus.adapters.out.persistence.mappers.EncounterStatusPersistenceMapper;

public class EncounterStatusRepositoryAdapter implements EncounterStatusRepository {

    private final EncounterStatusJpaRepository jpaRepository;
    private final EncounterStatusPersistenceMapper mapper;

    public EncounterStatusRepositoryAdapter(
            EncounterStatusJpaRepository jpaRepository,
            EncounterStatusPersistenceMapper mapper
    ) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public EncounterStatus save(EncounterStatus entity) {
        EncounterStatusJpaEntity jpaEntity = mapper.toJpa(entity);
        EncounterStatusJpaEntity saved = jpaRepository.save(jpaEntity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<EncounterStatus> findById(EncounterStatusId id) {
        return jpaRepository.findById(id.value())
                .map(mapper::toDomain);
    }

    @Override
    public List<EncounterStatus> findAll() {
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
    public void delete(EncounterStatus entity) {
        jpaRepository.deleteById(entity.id().value());
    }
}