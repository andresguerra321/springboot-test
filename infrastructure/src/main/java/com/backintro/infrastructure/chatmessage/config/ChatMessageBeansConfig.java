package com.backintro.infrastructure.chatmessage.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.chatmessage.usecase.DeleteChatMessageUseCase;
import com.backintro.application.chatmessage.usecase.GetChatMessageByIdUseCase;
import com.backintro.application.chatmessage.usecase.ListChatMessageUseCase;
import com.backintro.application.chatmessage.usecase.RegisterChatMessageUseCase;
import com.backintro.application.chatmessage.usecase.UpdateChatMessageUseCase;
import com.backintro.domain.chatmessage.port.repository.ChatMessageRepository;
import com.backintro.infrastructure.chatmessage.adapters.out.persistence.mappers.ChatMessagePersistenceMapper;
import com.backintro.infrastructure.chatmessage.adapters.out.persistence.repositories.ChatMessageJpaRepository;
import com.backintro.infrastructure.chatmessage.adapters.out.persistence.repositories.ChatMessageRepositoryAdapter;

@Configuration
public class ChatMessageBeansConfig {

    @Bean
    public ChatMessagePersistenceMapper chatmessagePersistenceMapper() {
        return new ChatMessagePersistenceMapper();
    }

    @Bean
    public ChatMessageRepository chatmessageRepository(ChatMessageJpaRepository repository, ChatMessagePersistenceMapper mapper) {
        return new ChatMessageRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterChatMessageUseCase registerChatMessageUseCase(ChatMessageRepository repository, com.backintro.domain.messagetype.port.repository.MessageTypeRepository messageTypeRepository) {
        return new RegisterChatMessageUseCase(repository, messageTypeRepository);
    }

    @Bean
    public GetChatMessageByIdUseCase getChatMessageByIdUseCase(ChatMessageRepository repository, com.backintro.domain.messagetype.port.repository.MessageTypeRepository messageTypeRepository) {
        return new GetChatMessageByIdUseCase(repository, messageTypeRepository);
    }

    @Bean
    public ListChatMessageUseCase listChatMessageUseCase(ChatMessageRepository repository, com.backintro.domain.messagetype.port.repository.MessageTypeRepository messageTypeRepository) {
        return new ListChatMessageUseCase(repository, messageTypeRepository);
    }

    @Bean
    public UpdateChatMessageUseCase updateChatMessageUseCase(ChatMessageRepository repository, com.backintro.domain.messagetype.port.repository.MessageTypeRepository messageTypeRepository) {
        return new UpdateChatMessageUseCase(repository, messageTypeRepository);
    }

    @Bean
    public DeleteChatMessageUseCase deleteChatMessageUseCase(ChatMessageRepository repository) {
        return new DeleteChatMessageUseCase(repository);
    }
}