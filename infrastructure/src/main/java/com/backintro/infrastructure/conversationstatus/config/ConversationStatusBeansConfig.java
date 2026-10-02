package com.backintro.infrastructure.conversationstatus.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.conversationstatus.usecase.DeleteConversationStatusUseCase;
import com.backintro.application.conversationstatus.usecase.GetConversationStatusByIdUseCase;
import com.backintro.application.conversationstatus.usecase.ListConversationStatusUseCase;
import com.backintro.application.conversationstatus.usecase.RegisterConversationStatusUseCase;
import com.backintro.application.conversationstatus.usecase.UpdateConversationStatusUseCase;
import com.backintro.domain.conversationstatus.port.repository.ConversationStatusRepository;
import com.backintro.infrastructure.conversationstatus.adapters.out.persistence.mappers.ConversationStatusPersistenceMapper;
import com.backintro.infrastructure.conversationstatus.adapters.out.persistence.repositories.ConversationStatusJpaRepository;
import com.backintro.infrastructure.conversationstatus.adapters.out.persistence.repositories.ConversationStatusRepositoryAdapter;

@Configuration
public class ConversationStatusBeansConfig {

    @Bean
    public ConversationStatusPersistenceMapper conversationstatusPersistenceMapper() {
        return new ConversationStatusPersistenceMapper();
    }

    @Bean
    public ConversationStatusRepository conversationstatusRepository(ConversationStatusJpaRepository repository, ConversationStatusPersistenceMapper mapper) {
        return new ConversationStatusRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterConversationStatusUseCase registerConversationStatusUseCase(ConversationStatusRepository repository) {
        return new RegisterConversationStatusUseCase(repository);
    }

    @Bean
    public GetConversationStatusByIdUseCase getConversationStatusByIdUseCase(ConversationStatusRepository repository) {
        return new GetConversationStatusByIdUseCase(repository);
    }

    @Bean
    public ListConversationStatusUseCase listConversationStatusUseCase(ConversationStatusRepository repository) {
        return new ListConversationStatusUseCase(repository);
    }

    @Bean
    public UpdateConversationStatusUseCase updateConversationStatusUseCase(ConversationStatusRepository repository) {
        return new UpdateConversationStatusUseCase(repository);
    }

    @Bean
    public DeleteConversationStatusUseCase deleteConversationStatusUseCase(ConversationStatusRepository repository) {
        return new DeleteConversationStatusUseCase(repository);
    }
}