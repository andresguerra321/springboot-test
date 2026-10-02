package com.backintro.infrastructure.chatconversation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.chatconversation.usecase.DeleteChatConversationUseCase;
import com.backintro.application.chatconversation.usecase.GetChatConversationByIdUseCase;
import com.backintro.application.chatconversation.usecase.ListChatConversationUseCase;
import com.backintro.application.chatconversation.usecase.RegisterChatConversationUseCase;
import com.backintro.application.chatconversation.usecase.UpdateChatConversationUseCase;
import com.backintro.domain.chatconversation.port.repository.ChatConversationRepository;
import com.backintro.infrastructure.chatconversation.adapters.out.persistence.mappers.ChatConversationPersistenceMapper;
import com.backintro.infrastructure.chatconversation.adapters.out.persistence.repositories.ChatConversationJpaRepository;
import com.backintro.infrastructure.chatconversation.adapters.out.persistence.repositories.ChatConversationRepositoryAdapter;

@Configuration
public class ChatConversationBeansConfig {

    @Bean
    public ChatConversationPersistenceMapper chatconversationPersistenceMapper() {
        return new ChatConversationPersistenceMapper();
    }

    @Bean
    public ChatConversationRepository chatconversationRepository(ChatConversationJpaRepository repository, ChatConversationPersistenceMapper mapper) {
        return new ChatConversationRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterChatConversationUseCase registerChatConversationUseCase(ChatConversationRepository repository, com.backintro.domain.conversationstatus.port.repository.ConversationStatusRepository conversationStatusRepository, com.backintro.domain.priority.port.repository.PriorityRepository priorityRepository) {
        return new RegisterChatConversationUseCase(repository, conversationStatusRepository, priorityRepository);
    }

    @Bean
    public GetChatConversationByIdUseCase getChatConversationByIdUseCase(ChatConversationRepository repository, com.backintro.domain.conversationstatus.port.repository.ConversationStatusRepository conversationStatusRepository, com.backintro.domain.priority.port.repository.PriorityRepository priorityRepository) {
        return new GetChatConversationByIdUseCase(repository, conversationStatusRepository, priorityRepository);
    }

    @Bean
    public ListChatConversationUseCase listChatConversationUseCase(ChatConversationRepository repository, com.backintro.domain.conversationstatus.port.repository.ConversationStatusRepository conversationStatusRepository, com.backintro.domain.priority.port.repository.PriorityRepository priorityRepository) {
        return new ListChatConversationUseCase(repository, conversationStatusRepository, priorityRepository);
    }

    @Bean
    public UpdateChatConversationUseCase updateChatConversationUseCase(ChatConversationRepository repository, com.backintro.domain.conversationstatus.port.repository.ConversationStatusRepository conversationStatusRepository, com.backintro.domain.priority.port.repository.PriorityRepository priorityRepository) {
        return new UpdateChatConversationUseCase(repository, conversationStatusRepository, priorityRepository);
    }

    @Bean
    public DeleteChatConversationUseCase deleteChatConversationUseCase(ChatConversationRepository repository) {
        return new DeleteChatConversationUseCase(repository);
    }
}