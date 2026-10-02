package com.backintro.application.conversationstatus.usecase;

import com.backintro.application.conversationstatus.command.RegisterConversationStatusCommand;
import com.backintro.application.conversationstatus.dto.ConversationStatusResponse;
import com.backintro.domain.conversationstatus.model.aggregate.ConversationStatus;
import com.backintro.domain.conversationstatus.port.repository.ConversationStatusRepository;

public class RegisterConversationStatusUseCase {
    private final ConversationStatusRepository repository;

    public RegisterConversationStatusUseCase(
            ConversationStatusRepository repository
    ) {
        this.repository = repository;
    }

    public ConversationStatusResponse execute(RegisterConversationStatusCommand command) {
        ConversationStatus entity = ConversationStatus.register(
                command.nameStatus()
        );
        ConversationStatus saved = repository.save(entity);
        return new ConversationStatusResponse(
                saved.id().value(),
                saved.nameStatus(),
                null,
                null
        );
    }
}