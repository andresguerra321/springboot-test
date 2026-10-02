package com.backintro.application.chatescalationstatushistory.usecase;

import com.backintro.application.chatescalationstatushistory.dto.ChatEscalationStatusHistoryResponse;
import com.backintro.application.chatescalationstatushistory.exception.ChatEscalationStatusHistoryNotFoundApplicationException;
import com.backintro.domain.chatescalationstatushistory.model.valueobject.ChatEscalationStatusHistoryId;
import com.backintro.domain.chatescalationstatushistory.port.repository.ChatEscalationStatusHistoryRepository;
import com.backintro.domain.escalationstatus.port.repository.EscalationStatusRepository;

public class GetChatEscalationStatusHistoryByIdUseCase {
    private final ChatEscalationStatusHistoryRepository repository;
    private final EscalationStatusRepository escalationStatusRepository;

    public GetChatEscalationStatusHistoryByIdUseCase(
            ChatEscalationStatusHistoryRepository repository,
            EscalationStatusRepository escalationStatusRepository
    ) {
        this.repository = repository;
        this.escalationStatusRepository = escalationStatusRepository;
    }

    public ChatEscalationStatusHistoryResponse execute(ChatEscalationStatusHistoryId id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new ChatEscalationStatusHistoryNotFoundApplicationException(id.value().toString()));
        return new ChatEscalationStatusHistoryResponse(
                entity.id().value(),
                entity.escalationId(),
                entity.escalationStatusId(),
                escalationStatusRepository.findById(new com.backintro.domain.escalationstatus.model.valueobject.EscalationStatusId(entity.escalationStatusId())).map(c -> c.nameStatus()).orElse(null),
                entity.changedAt(),
                null
        );
    }
}