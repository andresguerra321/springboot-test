package com.backintro.application.chatescalation.usecase;

import com.backintro.application.chatescalation.dto.ChatEscalationResponse;
import com.backintro.application.chatescalation.exception.ChatEscalationNotFoundApplicationException;
import com.backintro.domain.chatescalation.model.valueobject.ChatEscalationId;
import com.backintro.domain.chatescalation.port.repository.ChatEscalationRepository;
import com.backintro.domain.escalationstatus.port.repository.EscalationStatusRepository;

public class GetChatEscalationByIdUseCase {
    private final ChatEscalationRepository repository;
    private final EscalationStatusRepository escalationStatusRepository;

    public GetChatEscalationByIdUseCase(
            ChatEscalationRepository repository,
            EscalationStatusRepository escalationStatusRepository
    ) {
        this.repository = repository;
        this.escalationStatusRepository = escalationStatusRepository;
    }

    public ChatEscalationResponse execute(ChatEscalationId id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new ChatEscalationNotFoundApplicationException(id.value().toString()));
        return new ChatEscalationResponse(
                entity.id().value(),
                entity.conversationId(),
                entity.statusId(),
                escalationStatusRepository.findById(new com.backintro.domain.escalationstatus.model.valueobject.EscalationStatusId(entity.statusId())).map(c -> c.nameStatus()).orElse(null),
                entity.fromAi(),
                entity.reason(),
                null
        );
    }
}