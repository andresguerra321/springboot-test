package com.backintro.infrastructure.airunstatus.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.airunstatus.usecase.DeleteAiRunStatusUseCase;
import com.backintro.application.airunstatus.usecase.GetAiRunStatusByIdUseCase;
import com.backintro.application.airunstatus.usecase.ListAiRunStatusUseCase;
import com.backintro.application.airunstatus.usecase.RegisterAiRunStatusUseCase;
import com.backintro.application.airunstatus.usecase.UpdateAiRunStatusUseCase;
import com.backintro.domain.airunstatus.port.repository.AiRunStatusRepository;
import com.backintro.infrastructure.airunstatus.adapters.out.persistence.mappers.AiRunStatusPersistenceMapper;
import com.backintro.infrastructure.airunstatus.adapters.out.persistence.repositories.AiRunStatusJpaRepository;
import com.backintro.infrastructure.airunstatus.adapters.out.persistence.repositories.AiRunStatusRepositoryAdapter;

@Configuration
public class AiRunStatusBeansConfig {

    @Bean
    public AiRunStatusPersistenceMapper airunstatusPersistenceMapper() {
        return new AiRunStatusPersistenceMapper();
    }

    @Bean
    public AiRunStatusRepository airunstatusRepository(AiRunStatusJpaRepository repository, AiRunStatusPersistenceMapper mapper) {
        return new AiRunStatusRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterAiRunStatusUseCase registerAiRunStatusUseCase(AiRunStatusRepository repository) {
        return new RegisterAiRunStatusUseCase(repository);
    }

    @Bean
    public GetAiRunStatusByIdUseCase getAiRunStatusByIdUseCase(AiRunStatusRepository repository) {
        return new GetAiRunStatusByIdUseCase(repository);
    }

    @Bean
    public ListAiRunStatusUseCase listAiRunStatusUseCase(AiRunStatusRepository repository) {
        return new ListAiRunStatusUseCase(repository);
    }

    @Bean
    public UpdateAiRunStatusUseCase updateAiRunStatusUseCase(AiRunStatusRepository repository) {
        return new UpdateAiRunStatusUseCase(repository);
    }

    @Bean
    public DeleteAiRunStatusUseCase deleteAiRunStatusUseCase(AiRunStatusRepository repository) {
        return new DeleteAiRunStatusUseCase(repository);
    }
}