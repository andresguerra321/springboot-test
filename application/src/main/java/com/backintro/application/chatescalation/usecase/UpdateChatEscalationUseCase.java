package com.backintro.application.chatescalation.usecase;

import com.backintro.application.chatescalation.command.UpdateChatEscalationCommand;
import com.backintro.application.chatescalation.dto.ChatEscalationResponse;
import com.backintro.application.chatescalation.exception.ChatEscalationNotFoundApplicationException;
import com.backintro.domain.chatescalation.port.repository.ChatEscalationRepository;
import com.backintro.domain.escalationstatus.port.repository.EscalationStatusRepository;

public class UpdateChatEscalationUseCase {
    private final ChatEscalationRepository repository;
    private final EscalationStatusRepository escalationStatusRepository;

    public UpdateChatEscalationUseCase(
            ChatEscalationRepository repository,
            EscalationStatusRepository escalationStatusRepository
    ) {
        this.repository = repository;
        this.escalationStatusRepository = escalationStatusRepository;
    }

    public ChatEscalationResponse execute(UpdateChatEscalationCommand command) {
        var entity = repository.findById(command.id())
                .orElseThrow(() -> new ChatEscalationNotFoundApplicationException(command.id().value().toString()));

        entity.update(
                command.conversationId(),
                command.statusId(),
                command.fromAi(),
                command.reason()
        );

        var updated = repository.save(entity);
        return new ChatEscalationResponse(
                updated.id().value(),
                updated.conversationId(),
                updated.statusId(),
                escalationStatusRepository.findById(new com.backintro.domain.escalationstatus.model.valueobject.EscalationStatusId(updated.statusId())).map(c -> c.nameStatus()).orElse(null),
                updated.fromAi(),
                updated.reason(),
                null
        );
    }
}