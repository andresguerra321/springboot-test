package com.backintro.infrastructure.chatparticipant.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.chatparticipant.usecase.DeleteChatParticipantUseCase;
import com.backintro.application.chatparticipant.usecase.GetChatParticipantByIdUseCase;
import com.backintro.application.chatparticipant.usecase.ListChatParticipantUseCase;
import com.backintro.application.chatparticipant.usecase.RegisterChatParticipantUseCase;
import com.backintro.application.chatparticipant.usecase.UpdateChatParticipantUseCase;
import com.backintro.domain.chatparticipant.port.repository.ChatParticipantRepository;
import com.backintro.infrastructure.chatparticipant.adapters.out.persistence.mappers.ChatParticipantPersistenceMapper;
import com.backintro.infrastructure.chatparticipant.adapters.out.persistence.repositories.ChatParticipantJpaRepository;
import com.backintro.infrastructure.chatparticipant.adapters.out.persistence.repositories.ChatParticipantRepositoryAdapter;

@Configuration
public class ChatParticipantBeansConfig {

    @Bean
    public ChatParticipantPersistenceMapper chatparticipantPersistenceMapper() {
        return new ChatParticipantPersistenceMapper();
    }

    @Bean
    public ChatParticipantRepository chatparticipantRepository(ChatParticipantJpaRepository repository, ChatParticipantPersistenceMapper mapper) {
        return new ChatParticipantRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterChatParticipantUseCase registerChatParticipantUseCase(ChatParticipantRepository repository, com.backintro.domain.sendertype.port.repository.SenderTypeRepository senderTypeRepository) {
        return new RegisterChatParticipantUseCase(repository, senderTypeRepository);
    }

    @Bean
    public GetChatParticipantByIdUseCase getChatParticipantByIdUseCase(ChatParticipantRepository repository, com.backintro.domain.sendertype.port.repository.SenderTypeRepository senderTypeRepository) {
        return new GetChatParticipantByIdUseCase(repository, senderTypeRepository);
    }

    @Bean
    public ListChatParticipantUseCase listChatParticipantUseCase(ChatParticipantRepository repository, com.backintro.domain.sendertype.port.repository.SenderTypeRepository senderTypeRepository) {
        return new ListChatParticipantUseCase(repository, senderTypeRepository);
    }

    @Bean
    public UpdateChatParticipantUseCase updateChatParticipantUseCase(ChatParticipantRepository repository, com.backintro.domain.sendertype.port.repository.SenderTypeRepository senderTypeRepository) {
        return new UpdateChatParticipantUseCase(repository, senderTypeRepository);
    }

    @Bean
    public DeleteChatParticipantUseCase deleteChatParticipantUseCase(ChatParticipantRepository repository) {
        return new DeleteChatParticipantUseCase(repository);
    }
}