package com.backintro.infrastructure.providermodelai.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.providermodelai.usecase.DeleteProviderModelAiUseCase;
import com.backintro.application.providermodelai.usecase.GetProviderModelAiByIdUseCase;
import com.backintro.application.providermodelai.usecase.ListProviderModelAiUseCase;
import com.backintro.application.providermodelai.usecase.RegisterProviderModelAiUseCase;
import com.backintro.application.providermodelai.usecase.UpdateProviderModelAiUseCase;
import com.backintro.domain.providermodelai.port.repository.ProviderModelAiRepository;
import com.backintro.infrastructure.providermodelai.adapters.out.persistence.mappers.ProviderModelAiPersistenceMapper;
import com.backintro.infrastructure.providermodelai.adapters.out.persistence.repositories.ProviderModelAiJpaRepository;
import com.backintro.infrastructure.providermodelai.adapters.out.persistence.repositories.ProviderModelAiRepositoryAdapter;

@Configuration
public class ProviderModelAiBeansConfig {

    @Bean
    public ProviderModelAiPersistenceMapper providermodelaiPersistenceMapper() {
        return new ProviderModelAiPersistenceMapper();
    }

    @Bean
    public ProviderModelAiRepository providermodelaiRepository(ProviderModelAiJpaRepository repository, ProviderModelAiPersistenceMapper mapper) {
        return new ProviderModelAiRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterProviderModelAiUseCase registerProviderModelAiUseCase(ProviderModelAiRepository repository) {
        return new RegisterProviderModelAiUseCase(repository);
    }

    @Bean
    public GetProviderModelAiByIdUseCase getProviderModelAiByIdUseCase(ProviderModelAiRepository repository) {
        return new GetProviderModelAiByIdUseCase(repository);
    }

    @Bean
    public ListProviderModelAiUseCase listProviderModelAiUseCase(ProviderModelAiRepository repository) {
        return new ListProviderModelAiUseCase(repository);
    }

    @Bean
    public UpdateProviderModelAiUseCase updateProviderModelAiUseCase(ProviderModelAiRepository repository) {
        return new UpdateProviderModelAiUseCase(repository);
    }

    @Bean
    public DeleteProviderModelAiUseCase deleteProviderModelAiUseCase(ProviderModelAiRepository repository) {
        return new DeleteProviderModelAiUseCase(repository);
    }
}