package com.backintro.infrastructure.aimodel.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.aimodel.usecase.DeleteAiModelUseCase;
import com.backintro.application.aimodel.usecase.GetAiModelByIdUseCase;
import com.backintro.application.aimodel.usecase.ListAiModelUseCase;
import com.backintro.application.aimodel.usecase.RegisterAiModelUseCase;
import com.backintro.application.aimodel.usecase.UpdateAiModelUseCase;
import com.backintro.domain.aimodel.port.repository.AiModelRepository;
import com.backintro.infrastructure.aimodel.adapters.out.persistence.mappers.AiModelPersistenceMapper;
import com.backintro.infrastructure.aimodel.adapters.out.persistence.repositories.AiModelJpaRepository;
import com.backintro.infrastructure.aimodel.adapters.out.persistence.repositories.AiModelRepositoryAdapter;

@Configuration
public class AiModelBeansConfig {

    @Bean
    public AiModelPersistenceMapper aimodelPersistenceMapper() {
        return new AiModelPersistenceMapper();
    }

    @Bean
    public AiModelRepository aimodelRepository(AiModelJpaRepository repository, AiModelPersistenceMapper mapper) {
        return new AiModelRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterAiModelUseCase registerAiModelUseCase(AiModelRepository repository, com.backintro.domain.providermodelai.port.repository.ProviderModelAiRepository providerModelAiRepository) {
        return new RegisterAiModelUseCase(repository, providerModelAiRepository);
    }

    @Bean
    public GetAiModelByIdUseCase getAiModelByIdUseCase(AiModelRepository repository, com.backintro.domain.providermodelai.port.repository.ProviderModelAiRepository providerModelAiRepository) {
        return new GetAiModelByIdUseCase(repository, providerModelAiRepository);
    }

    @Bean
    public ListAiModelUseCase listAiModelUseCase(AiModelRepository repository, com.backintro.domain.providermodelai.port.repository.ProviderModelAiRepository providerModelAiRepository) {
        return new ListAiModelUseCase(repository, providerModelAiRepository);
    }

    @Bean
    public UpdateAiModelUseCase updateAiModelUseCase(AiModelRepository repository, com.backintro.domain.providermodelai.port.repository.ProviderModelAiRepository providerModelAiRepository) {
        return new UpdateAiModelUseCase(repository, providerModelAiRepository);
    }

    @Bean
    public DeleteAiModelUseCase deleteAiModelUseCase(AiModelRepository repository) {
        return new DeleteAiModelUseCase(repository);
    }
}