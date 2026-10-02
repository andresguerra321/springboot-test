package com.backintro.infrastructure.encounterstatus.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.encounterstatus.usecase.DeleteEncounterStatusUseCase;
import com.backintro.application.encounterstatus.usecase.GetEncounterStatusByIdUseCase;
import com.backintro.application.encounterstatus.usecase.ListEncounterStatusUseCase;
import com.backintro.application.encounterstatus.usecase.RegisterEncounterStatusUseCase;
import com.backintro.application.encounterstatus.usecase.UpdateEncounterStatusUseCase;
import com.backintro.domain.encounterstatus.port.repository.EncounterStatusRepository;
import com.backintro.infrastructure.encounterstatus.adapters.out.persistence.mappers.EncounterStatusPersistenceMapper;
import com.backintro.infrastructure.encounterstatus.adapters.out.persistence.repositories.EncounterStatusJpaRepository;
import com.backintro.infrastructure.encounterstatus.adapters.out.persistence.repositories.EncounterStatusRepositoryAdapter;

@Configuration
public class EncounterStatusBeansConfig {

    @Bean
    public EncounterStatusPersistenceMapper encounterstatusPersistenceMapper() {
        return new EncounterStatusPersistenceMapper();
    }

    @Bean
    public EncounterStatusRepository encounterstatusRepository(EncounterStatusJpaRepository repository, EncounterStatusPersistenceMapper mapper) {
        return new EncounterStatusRepositoryAdapter(
                repository,
                mapper
        );
    }

    @Bean
    public RegisterEncounterStatusUseCase registerEncounterStatusUseCase(EncounterStatusRepository repository) {
        return new RegisterEncounterStatusUseCase(
                repository
        );
    }

    @Bean
    public GetEncounterStatusByIdUseCase getEncounterStatusByIdUseCase(EncounterStatusRepository repository) {
        return new GetEncounterStatusByIdUseCase(
                repository
        );
    }

    @Bean
    public ListEncounterStatusUseCase listEncounterStatusUseCase(EncounterStatusRepository repository) {
        return new ListEncounterStatusUseCase(
                repository
        );
    }

    @Bean
    public UpdateEncounterStatusUseCase updateEncounterStatusUseCase(EncounterStatusRepository repository) {
        return new UpdateEncounterStatusUseCase(
                repository
        );
    }

    @Bean
    public DeleteEncounterStatusUseCase deleteEncounterStatusUseCase(EncounterStatusRepository repository) {
        return new DeleteEncounterStatusUseCase(
                repository
        );
    }
}