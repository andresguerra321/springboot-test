package com.backintro.infrastructure.chatairunmetric.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.chatairunmetric.usecase.DeleteChatAiRunMetricUseCase;
import com.backintro.application.chatairunmetric.usecase.GetChatAiRunMetricByIdUseCase;
import com.backintro.application.chatairunmetric.usecase.ListChatAiRunMetricUseCase;
import com.backintro.application.chatairunmetric.usecase.RegisterChatAiRunMetricUseCase;
import com.backintro.application.chatairunmetric.usecase.UpdateChatAiRunMetricUseCase;
import com.backintro.domain.chatairunmetric.port.repository.ChatAiRunMetricRepository;
import com.backintro.infrastructure.chatairunmetric.adapters.out.persistence.mappers.ChatAiRunMetricPersistenceMapper;
import com.backintro.infrastructure.chatairunmetric.adapters.out.persistence.repositories.ChatAiRunMetricJpaRepository;
import com.backintro.infrastructure.chatairunmetric.adapters.out.persistence.repositories.ChatAiRunMetricRepositoryAdapter;

@Configuration
public class ChatAiRunMetricBeansConfig {

    @Bean
    public ChatAiRunMetricPersistenceMapper chatairunmetricPersistenceMapper() {
        return new ChatAiRunMetricPersistenceMapper();
    }

    @Bean
    public ChatAiRunMetricRepository chatairunmetricRepository(ChatAiRunMetricJpaRepository repository, ChatAiRunMetricPersistenceMapper mapper) {
        return new ChatAiRunMetricRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterChatAiRunMetricUseCase registerChatAiRunMetricUseCase(ChatAiRunMetricRepository repository) {
        return new RegisterChatAiRunMetricUseCase(repository);
    }

    @Bean
    public GetChatAiRunMetricByIdUseCase getChatAiRunMetricByIdUseCase(ChatAiRunMetricRepository repository) {
        return new GetChatAiRunMetricByIdUseCase(repository);
    }

    @Bean
    public ListChatAiRunMetricUseCase listChatAiRunMetricUseCase(ChatAiRunMetricRepository repository) {
        return new ListChatAiRunMetricUseCase(repository);
    }

    @Bean
    public UpdateChatAiRunMetricUseCase updateChatAiRunMetricUseCase(ChatAiRunMetricRepository repository) {
        return new UpdateChatAiRunMetricUseCase(repository);
    }

    @Bean
    public DeleteChatAiRunMetricUseCase deleteChatAiRunMetricUseCase(ChatAiRunMetricRepository repository) {
        return new DeleteChatAiRunMetricUseCase(repository);
    }
}