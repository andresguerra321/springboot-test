package com.backintro.application.chatescalationstatushistory.usecase;

import java.util.List;

import com.backintro.application.chatescalationstatushistory.dto.ChatEscalationStatusHistoryResponse;
import com.backintro.domain.chatescalationstatushistory.port.repository.ChatEscalationStatusHistoryRepository;
import com.backintro.domain.escalationstatus.port.repository.EscalationStatusRepository;

public class ListChatEscalationStatusHistoryUseCase {
    private final ChatEscalationStatusHistoryRepository repository;
    private final EscalationStatusRepository escalationStatusRepository;

    public ListChatEscalationStatusHistoryUseCase(
            ChatEscalationStatusHistoryRepository repository,
            EscalationStatusRepository escalationStatusRepository
    ) {
        this.repository = repository;
        this.escalationStatusRepository = escalationStatusRepository;
    }

    public List<ChatEscalationStatusHistoryResponse> execute() {
        return repository.findAll()
                .stream()
                .map(entity -> new ChatEscalationStatusHistoryResponse(
                entity.id().value(),
                entity.escalationId(),
                entity.escalationStatusId(),
                escalationStatusRepository.findById(new com.backintro.domain.escalationstatus.model.valueobject.EscalationStatusId(entity.escalationStatusId())).map(c -> c.nameStatus()).orElse(null),
                entity.changedAt(),
                null
                ))
                .toList();
    }
}