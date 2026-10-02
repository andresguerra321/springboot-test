package com.backintro.application.chatairunerror.usecase;

import com.backintro.application.chatairunerror.command.UpdateChatAiRunErrorCommand;
import com.backintro.application.chatairunerror.dto.ChatAiRunErrorResponse;
import com.backintro.application.chatairunerror.exception.ChatAiRunErrorNotFoundApplicationException;
import com.backintro.domain.chatairunerror.port.repository.ChatAiRunErrorRepository;

public class UpdateChatAiRunErrorUseCase {
    private final ChatAiRunErrorRepository repository;

    public UpdateChatAiRunErrorUseCase(
            ChatAiRunErrorRepository repository
    ) {
        this.repository = repository;
    }

    public ChatAiRunErrorResponse execute(UpdateChatAiRunErrorCommand command) {
        var entity = repository.findById(command.id())
                .orElseThrow(() -> new ChatAiRunErrorNotFoundApplicationException(command.id().value().toString()));

        entity.update(
                command.aiRunId(),
                command.errorMessage(),
                command.errorCode(),
                command.providerErrorId()
        );

        var updated = repository.save(entity);
        return new ChatAiRunErrorResponse(
                updated.id().value(),
                updated.aiRunId(),
                updated.errorMessage(),
                updated.errorCode(),
                updated.providerErrorId(),
                null
        );
    }
}