package com.backintro.infrastructure.encountermodality.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.encountermodality.usecase.DeleteEncounterModalityUseCase;
import com.backintro.application.encountermodality.usecase.GetEncounterModalityByIdUseCase;
import com.backintro.application.encountermodality.usecase.ListEncounterModalityUseCase;
import com.backintro.application.encountermodality.usecase.RegisterEncounterModalityUseCase;
import com.backintro.application.encountermodality.usecase.UpdateEncounterModalityUseCase;
import com.backintro.domain.encountermodality.port.repository.EncounterModalityRepository;
import com.backintro.infrastructure.encountermodality.adapters.out.persistence.mappers.EncounterModalityPersistenceMapper;
import com.backintro.infrastructure.encountermodality.adapters.out.persistence.repositories.EncounterModalityJpaRepository;
import com.backintro.infrastructure.encountermodality.adapters.out.persistence.repositories.EncounterModalityRepositoryAdapter;

@Configuration
public class EncounterModalityBeansConfig {

    @Bean
    public EncounterModalityPersistenceMapper encountermodalityPersistenceMapper() {
        return new EncounterModalityPersistenceMapper();
    }

    @Bean
    public EncounterModalityRepository encountermodalityRepository(EncounterModalityJpaRepository repository, EncounterModalityPersistenceMapper mapper) {
        return new EncounterModalityRepositoryAdapter(
                repository,
                mapper
        );
    }

    @Bean
    public RegisterEncounterModalityUseCase registerEncounterModalityUseCase(EncounterModalityRepository repository) {
        return new RegisterEncounterModalityUseCase(
                repository
        );
    }

    @Bean
    public GetEncounterModalityByIdUseCase getEncounterModalityByIdUseCase(EncounterModalityRepository repository) {
        return new GetEncounterModalityByIdUseCase(
                repository
        );
    }

    @Bean
    public ListEncounterModalityUseCase listEncounterModalityUseCase(EncounterModalityRepository repository) {
        return new ListEncounterModalityUseCase(
                repository
        );
    }

    @Bean
    public UpdateEncounterModalityUseCase updateEncounterModalityUseCase(EncounterModalityRepository repository) {
        return new UpdateEncounterModalityUseCase(
                repository
        );
    }

    @Bean
    public DeleteEncounterModalityUseCase deleteEncounterModalityUseCase(EncounterModalityRepository repository) {
        return new DeleteEncounterModalityUseCase(
                repository
        );
    }
}