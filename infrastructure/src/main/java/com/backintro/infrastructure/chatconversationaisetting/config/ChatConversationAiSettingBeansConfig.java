package com.backintro.infrastructure.chatconversationaisetting.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.chatconversationaisetting.usecase.DeleteChatConversationAiSettingUseCase;
import com.backintro.application.chatconversationaisetting.usecase.GetChatConversationAiSettingByIdUseCase;
import com.backintro.application.chatconversationaisetting.usecase.ListChatConversationAiSettingUseCase;
import com.backintro.application.chatconversationaisetting.usecase.RegisterChatConversationAiSettingUseCase;
import com.backintro.application.chatconversationaisetting.usecase.UpdateChatConversationAiSettingUseCase;
import com.backintro.domain.chatconversationaisetting.port.repository.ChatConversationAiSettingRepository;
import com.backintro.infrastructure.chatconversationaisetting.adapters.out.persistence.mappers.ChatConversationAiSettingPersistenceMapper;
import com.backintro.infrastructure.chatconversationaisetting.adapters.out.persistence.repositories.ChatConversationAiSettingJpaRepository;
import com.backintro.infrastructure.chatconversationaisetting.adapters.out.persistence.repositories.ChatConversationAiSettingRepositoryAdapter;

@Configuration
public class ChatConversationAiSettingBeansConfig {

    @Bean
    public ChatConversationAiSettingPersistenceMapper chatconversationaisettingPersistenceMapper() {
        return new ChatConversationAiSettingPersistenceMapper();
    }

    @Bean
    public ChatConversationAiSettingRepository chatconversationaisettingRepository(ChatConversationAiSettingJpaRepository repository, ChatConversationAiSettingPersistenceMapper mapper) {
        return new ChatConversationAiSettingRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterChatConversationAiSettingUseCase registerChatConversationAiSettingUseCase(ChatConversationAiSettingRepository repository, com.backintro.domain.aimodel.port.repository.AiModelRepository aiModelRepository) {
        return new RegisterChatConversationAiSettingUseCase(repository, aiModelRepository);
    }

    @Bean
    public GetChatConversationAiSettingByIdUseCase getChatConversationAiSettingByIdUseCase(ChatConversationAiSettingRepository repository, com.backintro.domain.aimodel.port.repository.AiModelRepository aiModelRepository) {
        return new GetChatConversationAiSettingByIdUseCase(repository, aiModelRepository);
    }

    @Bean
    public ListChatConversationAiSettingUseCase listChatConversationAiSettingUseCase(ChatConversationAiSettingRepository repository, com.backintro.domain.aimodel.port.repository.AiModelRepository aiModelRepository) {
        return new ListChatConversationAiSettingUseCase(repository, aiModelRepository);
    }

    @Bean
    public UpdateChatConversationAiSettingUseCase updateChatConversationAiSettingUseCase(ChatConversationAiSettingRepository repository, com.backintro.domain.aimodel.port.repository.AiModelRepository aiModelRepository) {
        return new UpdateChatConversationAiSettingUseCase(repository, aiModelRepository);
    }

    @Bean
    public DeleteChatConversationAiSettingUseCase deleteChatConversationAiSettingUseCase(ChatConversationAiSettingRepository repository) {
        return new DeleteChatConversationAiSettingUseCase(repository);
    }
}