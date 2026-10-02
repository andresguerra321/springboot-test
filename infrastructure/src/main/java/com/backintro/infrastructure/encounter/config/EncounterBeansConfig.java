package com.backintro.infrastructure.encounter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.encounter.usecase.DeleteEncounterUseCase;
import com.backintro.application.encounter.usecase.GetEncounterByIdUseCase;
import com.backintro.application.encounter.usecase.ListEncounterUseCase;
import com.backintro.application.encounter.usecase.RegisterEncounterUseCase;
import com.backintro.application.encounter.usecase.UpdateEncounterUseCase;
import com.backintro.domain.encounter.port.repository.EncounterRepository;
import com.backintro.infrastructure.encounter.adapters.out.persistence.mappers.EncounterPersistenceMapper;
import com.backintro.infrastructure.encounter.adapters.out.persistence.repositories.EncounterJpaRepository;
import com.backintro.infrastructure.encounter.adapters.out.persistence.repositories.EncounterRepositoryAdapter;

@Configuration
public class EncounterBeansConfig {

    @Bean
    public EncounterPersistenceMapper encounterPersistenceMapper() {
        return new EncounterPersistenceMapper();
    }

    @Bean
    public EncounterRepository encounterRepository(EncounterJpaRepository repository, EncounterPersistenceMapper mapper) {
        return new EncounterRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterEncounterUseCase registerEncounterUseCase(EncounterRepository repository, com.backintro.domain.professional.port.repository.ProfessionalRepository professionalRepository, com.backintro.domain.encountertype.port.repository.EncounterTypeRepository encounterTypeRepository, com.backintro.domain.encountermodality.port.repository.EncounterModalityRepository encounterModalityRepository, com.backintro.domain.encounterstatus.port.repository.EncounterStatusRepository encounterStatusRepository) {
        return new RegisterEncounterUseCase(repository, professionalRepository, encounterTypeRepository, encounterModalityRepository, encounterStatusRepository);
    }

    @Bean
    public GetEncounterByIdUseCase getEncounterByIdUseCase(EncounterRepository repository, com.backintro.domain.professional.port.repository.ProfessionalRepository professionalRepository, com.backintro.domain.encountertype.port.repository.EncounterTypeRepository encounterTypeRepository, com.backintro.domain.encountermodality.port.repository.EncounterModalityRepository encounterModalityRepository, com.backintro.domain.encounterstatus.port.repository.EncounterStatusRepository encounterStatusRepository) {
        return new GetEncounterByIdUseCase(repository, professionalRepository, encounterTypeRepository, encounterModalityRepository, encounterStatusRepository);
    }

    @Bean
    public ListEncounterUseCase listEncounterUseCase(EncounterRepository repository, com.backintro.domain.professional.port.repository.ProfessionalRepository professionalRepository, com.backintro.domain.encountertype.port.repository.EncounterTypeRepository encounterTypeRepository, com.backintro.domain.encountermodality.port.repository.EncounterModalityRepository encounterModalityRepository, com.backintro.domain.encounterstatus.port.repository.EncounterStatusRepository encounterStatusRepository) {
        return new ListEncounterUseCase(repository, professionalRepository, encounterTypeRepository, encounterModalityRepository, encounterStatusRepository);
    }

    @Bean
    public UpdateEncounterUseCase updateEncounterUseCase(EncounterRepository repository, com.backintro.domain.professional.port.repository.ProfessionalRepository professionalRepository, com.backintro.domain.encountertype.port.repository.EncounterTypeRepository encounterTypeRepository, com.backintro.domain.encountermodality.port.repository.EncounterModalityRepository encounterModalityRepository, com.backintro.domain.encounterstatus.port.repository.EncounterStatusRepository encounterStatusRepository) {
        return new UpdateEncounterUseCase(repository, professionalRepository, encounterTypeRepository, encounterModalityRepository, encounterStatusRepository);
    }

    @Bean
    public DeleteEncounterUseCase deleteEncounterUseCase(EncounterRepository repository) {
        return new DeleteEncounterUseCase(repository);
    }
}