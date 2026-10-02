package com.backintro.infrastructure.chatescalationassignment.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.chatescalationassignment.usecase.DeleteChatEscalationAssignmentUseCase;
import com.backintro.application.chatescalationassignment.usecase.GetChatEscalationAssignmentByIdUseCase;
import com.backintro.application.chatescalationassignment.usecase.ListChatEscalationAssignmentUseCase;
import com.backintro.application.chatescalationassignment.usecase.RegisterChatEscalationAssignmentUseCase;
import com.backintro.application.chatescalationassignment.usecase.UpdateChatEscalationAssignmentUseCase;
import com.backintro.domain.chatescalationassignment.port.repository.ChatEscalationAssignmentRepository;
import com.backintro.infrastructure.chatescalationassignment.adapters.out.persistence.mappers.ChatEscalationAssignmentPersistenceMapper;
import com.backintro.infrastructure.chatescalationassignment.adapters.out.persistence.repositories.ChatEscalationAssignmentJpaRepository;
import com.backintro.infrastructure.chatescalationassignment.adapters.out.persistence.repositories.ChatEscalationAssignmentRepositoryAdapter;

@Configuration
public class ChatEscalationAssignmentBeansConfig {

    @Bean
    public ChatEscalationAssignmentPersistenceMapper chatescalationassignmentPersistenceMapper() {
        return new ChatEscalationAssignmentPersistenceMapper();
    }

    @Bean
    public ChatEscalationAssignmentRepository chatescalationassignmentRepository(ChatEscalationAssignmentJpaRepository repository, ChatEscalationAssignmentPersistenceMapper mapper) {
        return new ChatEscalationAssignmentRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterChatEscalationAssignmentUseCase registerChatEscalationAssignmentUseCase(ChatEscalationAssignmentRepository repository, com.backintro.domain.professional.port.repository.ProfessionalRepository professionalRepository) {
        return new RegisterChatEscalationAssignmentUseCase(repository, professionalRepository);
    }

    @Bean
    public GetChatEscalationAssignmentByIdUseCase getChatEscalationAssignmentByIdUseCase(ChatEscalationAssignmentRepository repository, com.backintro.domain.professional.port.repository.ProfessionalRepository professionalRepository) {
        return new GetChatEscalationAssignmentByIdUseCase(repository, professionalRepository);
    }

    @Bean
    public ListChatEscalationAssignmentUseCase listChatEscalationAssignmentUseCase(ChatEscalationAssignmentRepository repository, com.backintro.domain.professional.port.repository.ProfessionalRepository professionalRepository) {
        return new ListChatEscalationAssignmentUseCase(repository, professionalRepository);
    }

    @Bean
    public UpdateChatEscalationAssignmentUseCase updateChatEscalationAssignmentUseCase(ChatEscalationAssignmentRepository repository, com.backintro.domain.professional.port.repository.ProfessionalRepository professionalRepository) {
        return new UpdateChatEscalationAssignmentUseCase(repository, professionalRepository);
    }

    @Bean
    public DeleteChatEscalationAssignmentUseCase deleteChatEscalationAssignmentUseCase(ChatEscalationAssignmentRepository repository) {
        return new DeleteChatEscalationAssignmentUseCase(repository);
    }
}