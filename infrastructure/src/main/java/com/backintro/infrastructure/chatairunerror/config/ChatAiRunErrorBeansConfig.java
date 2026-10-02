package com.backintro.infrastructure.chatairunerror.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.chatairunerror.usecase.DeleteChatAiRunErrorUseCase;
import com.backintro.application.chatairunerror.usecase.GetChatAiRunErrorByIdUseCase;
import com.backintro.application.chatairunerror.usecase.ListChatAiRunErrorUseCase;
import com.backintro.application.chatairunerror.usecase.RegisterChatAiRunErrorUseCase;
import com.backintro.application.chatairunerror.usecase.UpdateChatAiRunErrorUseCase;
import com.backintro.domain.chatairunerror.port.repository.ChatAiRunErrorRepository;
import com.backintro.infrastructure.chatairunerror.adapters.out.persistence.mappers.ChatAiRunErrorPersistenceMapper;
import com.backintro.infrastructure.chatairunerror.adapters.out.persistence.repositories.ChatAiRunErrorJpaRepository;
import com.backintro.infrastructure.chatairunerror.adapters.out.persistence.repositories.ChatAiRunErrorRepositoryAdapter;

@Configuration
public class ChatAiRunErrorBeansConfig {

    @Bean
    public ChatAiRunErrorPersistenceMapper chatairunerrorPersistenceMapper() {
        return new ChatAiRunErrorPersistenceMapper();
    }

    @Bean
    public ChatAiRunErrorRepository chatairunerrorRepository(ChatAiRunErrorJpaRepository repository, ChatAiRunErrorPersistenceMapper mapper) {
        return new ChatAiRunErrorRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterChatAiRunErrorUseCase registerChatAiRunErrorUseCase(ChatAiRunErrorRepository repository) {
        return new RegisterChatAiRunErrorUseCase(repository);
    }

    @Bean
    public GetChatAiRunErrorByIdUseCase getChatAiRunErrorByIdUseCase(ChatAiRunErrorRepository repository) {
        return new GetChatAiRunErrorByIdUseCase(repository);
    }

    @Bean
    public ListChatAiRunErrorUseCase listChatAiRunErrorUseCase(ChatAiRunErrorRepository repository) {
        return new ListChatAiRunErrorUseCase(repository);
    }

    @Bean
    public UpdateChatAiRunErrorUseCase updateChatAiRunErrorUseCase(ChatAiRunErrorRepository repository) {
        return new UpdateChatAiRunErrorUseCase(repository);
    }

    @Bean
    public DeleteChatAiRunErrorUseCase deleteChatAiRunErrorUseCase(ChatAiRunErrorRepository repository) {
        return new DeleteChatAiRunErrorUseCase(repository);
    }
}