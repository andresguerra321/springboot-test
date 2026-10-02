package com.backintro.application.chatescalation.usecase;

import com.backintro.application.chatescalation.command.RegisterChatEscalationCommand;
import com.backintro.application.chatescalation.dto.ChatEscalationResponse;
import com.backintro.domain.chatescalation.model.aggregate.ChatEscalation;
import com.backintro.domain.chatescalation.port.repository.ChatEscalationRepository;
import com.backintro.domain.escalationstatus.port.repository.EscalationStatusRepository;

public class RegisterChatEscalationUseCase {
    private final ChatEscalationRepository repository;
    private final EscalationStatusRepository escalationStatusRepository;

    public RegisterChatEscalationUseCase(
            ChatEscalationRepository repository,
            EscalationStatusRepository escalationStatusRepository
    ) {
        this.repository = repository;
        this.escalationStatusRepository = escalationStatusRepository;
    }

    public ChatEscalationResponse execute(RegisterChatEscalationCommand command) {
        ChatEscalation entity = ChatEscalation.register(
                command.conversationId(),
                command.statusId(),
                command.fromAi(),
                command.reason()
        );
        ChatEscalation saved = repository.save(entity);
        return new ChatEscalationResponse(
                saved.id().value(),
                saved.conversationId(),
                saved.statusId(),
                escalationStatusRepository.findById(new com.backintro.domain.escalationstatus.model.valueobject.EscalationStatusId(saved.statusId())).map(c -> c.nameStatus()).orElse(null),
                saved.fromAi(),
                saved.reason(),
                null
        );
    }
}