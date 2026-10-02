package com.backintro.application.chatescalationstatushistory.usecase;

import com.backintro.application.chatescalationstatushistory.command.UpdateChatEscalationStatusHistoryCommand;
import com.backintro.application.chatescalationstatushistory.dto.ChatEscalationStatusHistoryResponse;
import com.backintro.application.chatescalationstatushistory.exception.ChatEscalationStatusHistoryNotFoundApplicationException;
import com.backintro.domain.chatescalationstatushistory.port.repository.ChatEscalationStatusHistoryRepository;
import com.backintro.domain.escalationstatus.port.repository.EscalationStatusRepository;

public class UpdateChatEscalationStatusHistoryUseCase {
    private final ChatEscalationStatusHistoryRepository repository;
    private final EscalationStatusRepository escalationStatusRepository;

    public UpdateChatEscalationStatusHistoryUseCase(
            ChatEscalationStatusHistoryRepository repository,
            EscalationStatusRepository escalationStatusRepository
    ) {
        this.repository = repository;
        this.escalationStatusRepository = escalationStatusRepository;
    }

    public ChatEscalationStatusHistoryResponse execute(UpdateChatEscalationStatusHistoryCommand command) {
        var entity = repository.findById(command.id())
                .orElseThrow(() -> new ChatEscalationStatusHistoryNotFoundApplicationException(command.id().value().toString()));

        entity.update(
                command.escalationId(),
                command.escalationStatusId(),
                command.changedAt()
        );

        var updated = repository.save(entity);
        return new ChatEscalationStatusHistoryResponse(
                updated.id().value(),
                updated.escalationId(),
                updated.escalationStatusId(),
                escalationStatusRepository.findById(new com.backintro.domain.escalationstatus.model.valueobject.EscalationStatusId(updated.escalationStatusId())).map(c -> c.nameStatus()).orElse(null),
                updated.changedAt(),
                null
        );
    }
}