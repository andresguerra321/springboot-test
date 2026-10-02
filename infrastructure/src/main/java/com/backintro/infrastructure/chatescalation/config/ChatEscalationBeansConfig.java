package com.backintro.infrastructure.chatescalation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.chatescalation.usecase.DeleteChatEscalationUseCase;
import com.backintro.application.chatescalation.usecase.GetChatEscalationByIdUseCase;
import com.backintro.application.chatescalation.usecase.ListChatEscalationUseCase;
import com.backintro.application.chatescalation.usecase.RegisterChatEscalationUseCase;
import com.backintro.application.chatescalation.usecase.UpdateChatEscalationUseCase;
import com.backintro.domain.chatescalation.port.repository.ChatEscalationRepository;
import com.backintro.infrastructure.chatescalation.adapters.out.persistence.mappers.ChatEscalationPersistenceMapper;
import com.backintro.infrastructure.chatescalation.adapters.out.persistence.repositories.ChatEscalationJpaRepository;
import com.backintro.infrastructure.chatescalation.adapters.out.persistence.repositories.ChatEscalationRepositoryAdapter;

@Configuration
public class ChatEscalationBeansConfig {

    @Bean
    public ChatEscalationPersistenceMapper chatescalationPersistenceMapper() {
        return new ChatEscalationPersistenceMapper();
    }

    @Bean
    public ChatEscalationRepository chatescalationRepository(ChatEscalationJpaRepository repository, ChatEscalationPersistenceMapper mapper) {
        return new ChatEscalationRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterChatEscalationUseCase registerChatEscalationUseCase(ChatEscalationRepository repository, com.backintro.domain.escalationstatus.port.repository.EscalationStatusRepository escalationStatusRepository) {
        return new RegisterChatEscalationUseCase(repository, escalationStatusRepository);
    }

    @Bean
    public GetChatEscalationByIdUseCase getChatEscalationByIdUseCase(ChatEscalationRepository repository, com.backintro.domain.escalationstatus.port.repository.EscalationStatusRepository escalationStatusRepository) {
        return new GetChatEscalationByIdUseCase(repository, escalationStatusRepository);
    }

    @Bean
    public ListChatEscalationUseCase listChatEscalationUseCase(ChatEscalationRepository repository, com.backintro.domain.escalationstatus.port.repository.EscalationStatusRepository escalationStatusRepository) {
        return new ListChatEscalationUseCase(repository, escalationStatusRepository);
    }

    @Bean
    public UpdateChatEscalationUseCase updateChatEscalationUseCase(ChatEscalationRepository repository, com.backintro.domain.escalationstatus.port.repository.EscalationStatusRepository escalationStatusRepository) {
        return new UpdateChatEscalationUseCase(repository, escalationStatusRepository);
    }

    @Bean
    public DeleteChatEscalationUseCase deleteChatEscalationUseCase(ChatEscalationRepository repository) {
        return new DeleteChatEscalationUseCase(repository);
    }
}