package com.backintro.infrastructure.patientallergy.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.patientallergy.model.aggregate.PatientAllergy;
import com.backintro.domain.patientallergy.model.valueobject.PatientAllergyId;
import com.backintro.domain.patientallergy.port.repository.PatientAllergyRepository;
import com.backintro.infrastructure.patientallergy.adapters.out.persistence.entity.PatientAllergyJpaEntity;
import com.backintro.infrastructure.patientallergy.adapters.out.persistence.mappers.PatientAllergyPersistenceMapper;

public class PatientAllergyRepositoryAdapter implements PatientAllergyRepository {
    private final PatientAllergyJpaRepository jpaRepository;
    private final PatientAllergyPersistenceMapper mapper;

    public PatientAllergyRepositoryAdapter(PatientAllergyJpaRepository jpaRepository, PatientAllergyPersistenceMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public PatientAllergy save(PatientAllergy entity) {
        PatientAllergyJpaEntity jpaEntity = mapper.toJpa(entity);
        PatientAllergyJpaEntity saved = jpaRepository.save(jpaEntity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<PatientAllergy> findById(PatientAllergyId id) {
        return jpaRepository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<PatientAllergy> findAll() {
        return jpaRepository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(PatientAllergy entity) {
        jpaRepository.deleteById(entity.id().value());
    }
}