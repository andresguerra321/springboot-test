package com.backintro.application.chatescalationstatushistory.usecase;

import com.backintro.application.chatescalationstatushistory.command.RegisterChatEscalationStatusHistoryCommand;
import com.backintro.application.chatescalationstatushistory.dto.ChatEscalationStatusHistoryResponse;
import com.backintro.domain.chatescalationstatushistory.model.aggregate.ChatEscalationStatusHistory;
import com.backintro.domain.chatescalationstatushistory.port.repository.ChatEscalationStatusHistoryRepository;
import com.backintro.domain.escalationstatus.port.repository.EscalationStatusRepository;

public class RegisterChatEscalationStatusHistoryUseCase {
    private final ChatEscalationStatusHistoryRepository repository;
    private final EscalationStatusRepository escalationStatusRepository;

    public RegisterChatEscalationStatusHistoryUseCase(
            ChatEscalationStatusHistoryRepository repository,
            EscalationStatusRepository escalationStatusRepository
    ) {
        this.repository = repository;
        this.escalationStatusRepository = escalationStatusRepository;
    }

    public ChatEscalationStatusHistoryResponse execute(RegisterChatEscalationStatusHistoryCommand command) {
        ChatEscalationStatusHistory entity = ChatEscalationStatusHistory.register(
                command.escalationId(),
                command.escalationStatusId(),
                command.changedAt()
        );
        ChatEscalationStatusHistory saved = repository.save(entity);
        return new ChatEscalationStatusHistoryResponse(
                saved.id().value(),
                saved.escalationId(),
                saved.escalationStatusId(),
                escalationStatusRepository.findById(new com.backintro.domain.escalationstatus.model.valueobject.EscalationStatusId(saved.escalationStatusId())).map(c -> c.nameStatus()).orElse(null),
                saved.changedAt(),
                null
        );
    }
}