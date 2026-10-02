package com.backintro.infrastructure.chatairun.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.chatairun.usecase.DeleteChatAiRunUseCase;
import com.backintro.application.chatairun.usecase.GetChatAiRunByIdUseCase;
import com.backintro.application.chatairun.usecase.ListChatAiRunUseCase;
import com.backintro.application.chatairun.usecase.RegisterChatAiRunUseCase;
import com.backintro.application.chatairun.usecase.UpdateChatAiRunUseCase;
import com.backintro.domain.chatairun.port.repository.ChatAiRunRepository;
import com.backintro.infrastructure.chatairun.adapters.out.persistence.mappers.ChatAiRunPersistenceMapper;
import com.backintro.infrastructure.chatairun.adapters.out.persistence.repositories.ChatAiRunJpaRepository;
import com.backintro.infrastructure.chatairun.adapters.out.persistence.repositories.ChatAiRunRepositoryAdapter;

@Configuration
public class ChatAiRunBeansConfig {

    @Bean
    public ChatAiRunPersistenceMapper chatairunPersistenceMapper() {
        return new ChatAiRunPersistenceMapper();
    }

    @Bean
    public ChatAiRunRepository chatairunRepository(ChatAiRunJpaRepository repository, ChatAiRunPersistenceMapper mapper) {
        return new ChatAiRunRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterChatAiRunUseCase registerChatAiRunUseCase(ChatAiRunRepository repository, com.backintro.domain.aimodel.port.repository.AiModelRepository aiModelRepository, com.backintro.domain.airunstatus.port.repository.AiRunStatusRepository aiRunStatusRepository) {
        return new RegisterChatAiRunUseCase(repository, aiModelRepository, aiRunStatusRepository);
    }

    @Bean
    public GetChatAiRunByIdUseCase getChatAiRunByIdUseCase(ChatAiRunRepository repository, com.backintro.domain.aimodel.port.repository.AiModelRepository aiModelRepository, com.backintro.domain.airunstatus.port.repository.AiRunStatusRepository aiRunStatusRepository) {
        return new GetChatAiRunByIdUseCase(repository, aiModelRepository, aiRunStatusRepository);
    }

    @Bean
    public ListChatAiRunUseCase listChatAiRunUseCase(ChatAiRunRepository repository, com.backintro.domain.aimodel.port.repository.AiModelRepository aiModelRepository, com.backintro.domain.airunstatus.port.repository.AiRunStatusRepository aiRunStatusRepository) {
        return new ListChatAiRunUseCase(repository, aiModelRepository, aiRunStatusRepository);
    }

    @Bean
    public UpdateChatAiRunUseCase updateChatAiRunUseCase(ChatAiRunRepository repository, com.backintro.domain.aimodel.port.repository.AiModelRepository aiModelRepository, com.backintro.domain.airunstatus.port.repository.AiRunStatusRepository aiRunStatusRepository) {
        return new UpdateChatAiRunUseCase(repository, aiModelRepository, aiRunStatusRepository);
    }

    @Bean
    public DeleteChatAiRunUseCase deleteChatAiRunUseCase(ChatAiRunRepository repository) {
        return new DeleteChatAiRunUseCase(repository);
    }
}