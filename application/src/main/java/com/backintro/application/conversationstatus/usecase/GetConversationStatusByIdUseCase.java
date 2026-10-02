package com.backintro.application.conversationstatus.usecase;

import com.backintro.application.conversationstatus.dto.ConversationStatusResponse;
import com.backintro.application.conversationstatus.exception.ConversationStatusNotFoundApplicationException;
import com.backintro.domain.conversationstatus.model.valueobject.ConversationStatusId;
import com.backintro.domain.conversationstatus.port.repository.ConversationStatusRepository;

public class GetConversationStatusByIdUseCase {
    private final ConversationStatusRepository repository;

    public GetConversationStatusByIdUseCase(
            ConversationStatusRepository repository
    ) {
        this.repository = repository;
    }

    public ConversationStatusResponse execute(ConversationStatusId id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new ConversationStatusNotFoundApplicationException(id.value().toString()));
        return new ConversationStatusResponse(
                entity.id().value(),
                entity.nameStatus(),
                null,
                null
        );
    }
}