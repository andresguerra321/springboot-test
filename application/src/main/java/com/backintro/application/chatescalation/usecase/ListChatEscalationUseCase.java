package com.backintro.application.chatescalation.usecase;

import java.util.List;

import com.backintro.application.chatescalation.dto.ChatEscalationResponse;
import com.backintro.domain.chatescalation.port.repository.ChatEscalationRepository;
import com.backintro.domain.escalationstatus.port.repository.EscalationStatusRepository;

public class ListChatEscalationUseCase {
    private final ChatEscalationRepository repository;
    private final EscalationStatusRepository escalationStatusRepository;

    public ListChatEscalationUseCase(
            ChatEscalationRepository repository,
            EscalationStatusRepository escalationStatusRepository
    ) {
        this.repository = repository;
        this.escalationStatusRepository = escalationStatusRepository;
    }

    public List<ChatEscalationResponse> execute() {
        return repository.findAll()
                .stream()
                .map(entity -> new ChatEscalationResponse(
                entity.id().value(),
                entity.conversationId(),
                entity.statusId(),
                escalationStatusRepository.findById(new com.backintro.domain.escalationstatus.model.valueobject.EscalationStatusId(entity.statusId())).map(c -> c.nameStatus()).orElse(null),
                entity.fromAi(),
                entity.reason(),
                null
                ))
                .toList();
    }
}