package com.backintro.infrastructure.chatescalationstatushistory.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.chatescalationstatushistory.usecase.DeleteChatEscalationStatusHistoryUseCase;
import com.backintro.application.chatescalationstatushistory.usecase.GetChatEscalationStatusHistoryByIdUseCase;
import com.backintro.application.chatescalationstatushistory.usecase.ListChatEscalationStatusHistoryUseCase;
import com.backintro.application.chatescalationstatushistory.usecase.RegisterChatEscalationStatusHistoryUseCase;
import com.backintro.application.chatescalationstatushistory.usecase.UpdateChatEscalationStatusHistoryUseCase;
import com.backintro.domain.chatescalationstatushistory.port.repository.ChatEscalationStatusHistoryRepository;
import com.backintro.infrastructure.chatescalationstatushistory.adapters.out.persistence.mappers.ChatEscalationStatusHistoryPersistenceMapper;
import com.backintro.infrastructure.chatescalationstatushistory.adapters.out.persistence.repositories.ChatEscalationStatusHistoryJpaRepository;
import com.backintro.infrastructure.chatescalationstatushistory.adapters.out.persistence.repositories.ChatEscalationStatusHistoryRepositoryAdapter;

@Configuration
public class ChatEscalationStatusHistoryBeansConfig {

    @Bean
    public ChatEscalationStatusHistoryPersistenceMapper chatescalationstatushistoryPersistenceMapper() {
        return new ChatEscalationStatusHistoryPersistenceMapper();
    }

    @Bean
    public ChatEscalationStatusHistoryRepository chatescalationstatushistoryRepository(ChatEscalationStatusHistoryJpaRepository repository, ChatEscalationStatusHistoryPersistenceMapper mapper) {
        return new ChatEscalationStatusHistoryRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterChatEscalationStatusHistoryUseCase registerChatEscalationStatusHistoryUseCase(ChatEscalationStatusHistoryRepository repository, com.backintro.domain.escalationstatus.port.repository.EscalationStatusRepository escalationStatusRepository) {
        return new RegisterChatEscalationStatusHistoryUseCase(repository, escalationStatusRepository);
    }

    @Bean
    public GetChatEscalationStatusHistoryByIdUseCase getChatEscalationStatusHistoryByIdUseCase(ChatEscalationStatusHistoryRepository repository, com.backintro.domain.escalationstatus.port.repository.EscalationStatusRepository escalationStatusRepository) {
        return new GetChatEscalationStatusHistoryByIdUseCase(repository, escalationStatusRepository);
    }

    @Bean
    public ListChatEscalationStatusHistoryUseCase listChatEscalationStatusHistoryUseCase(ChatEscalationStatusHistoryRepository repository, com.backintro.domain.escalationstatus.port.repository.EscalationStatusRepository escalationStatusRepository) {
        return new ListChatEscalationStatusHistoryUseCase(repository, escalationStatusRepository);
    }

    @Bean
    public UpdateChatEscalationStatusHistoryUseCase updateChatEscalationStatusHistoryUseCase(ChatEscalationStatusHistoryRepository repository, com.backintro.domain.escalationstatus.port.repository.EscalationStatusRepository escalationStatusRepository) {
        return new UpdateChatEscalationStatusHistoryUseCase(repository, escalationStatusRepository);
    }

    @Bean
    public DeleteChatEscalationStatusHistoryUseCase deleteChatEscalationStatusHistoryUseCase(ChatEscalationStatusHistoryRepository repository) {
        return new DeleteChatEscalationStatusHistoryUseCase(repository);
    }
}