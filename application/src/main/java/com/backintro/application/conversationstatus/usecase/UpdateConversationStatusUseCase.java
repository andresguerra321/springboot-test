package com.backintro.application.conversationstatus.usecase;

import com.backintro.application.conversationstatus.command.UpdateConversationStatusCommand;
import com.backintro.application.conversationstatus.dto.ConversationStatusResponse;
import com.backintro.application.conversationstatus.exception.ConversationStatusNotFoundApplicationException;
import com.backintro.domain.conversationstatus.port.repository.ConversationStatusRepository;

public class UpdateConversationStatusUseCase {
    private final ConversationStatusRepository repository;

    public UpdateConversationStatusUseCase(
            ConversationStatusRepository repository
    ) {
        this.repository = repository;
    }

    public ConversationStatusResponse execute(UpdateConversationStatusCommand command) {
        var entity = repository.findById(command.id())
                .orElseThrow(() -> new ConversationStatusNotFoundApplicationException(command.id().value().toString()));

        entity.update(
                command.nameStatus()
        );

        var updated = repository.save(entity);
        return new ConversationStatusResponse(
                updated.id().value(),
                updated.nameStatus(),
                null,
                null
        );
    }
}