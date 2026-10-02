package com.backintro.application.chatairunerror.usecase;

import com.backintro.application.chatairunerror.dto.ChatAiRunErrorResponse;
import com.backintro.application.chatairunerror.exception.ChatAiRunErrorNotFoundApplicationException;
import com.backintro.domain.chatairunerror.model.valueobject.ChatAiRunErrorId;
import com.backintro.domain.chatairunerror.port.repository.ChatAiRunErrorRepository;

public class GetChatAiRunErrorByIdUseCase {
    private final ChatAiRunErrorRepository repository;

    public GetChatAiRunErrorByIdUseCase(
            ChatAiRunErrorRepository repository
    ) {
        this.repository = repository;
    }

    public ChatAiRunErrorResponse execute(ChatAiRunErrorId id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new ChatAiRunErrorNotFoundApplicationException(id.value().toString()));
        return new ChatAiRunErrorResponse(
                entity.id().value(),
                entity.aiRunId(),
                entity.errorMessage(),
                entity.errorCode(),
                entity.providerErrorId(),
                null
        );
    }
}