package com.backintro.application.chatconversation.usecase;

import com.backintro.application.chatconversation.command.UpdateChatConversationCommand;
import com.backintro.application.chatconversation.dto.ChatConversationResponse;
import com.backintro.application.chatconversation.exception.ChatConversationNotFoundApplicationException;
import com.backintro.domain.chatconversation.port.repository.ChatConversationRepository;
import com.backintro.domain.conversationstatus.port.repository.ConversationStatusRepository;
import com.backintro.domain.priority.port.repository.PriorityRepository;

public class UpdateChatConversationUseCase {
    private final ChatConversationRepository repository;
    private final ConversationStatusRepository conversationStatusRepository;
    private final PriorityRepository priorityRepository;

    public UpdateChatConversationUseCase(
            ChatConversationRepository repository,
            ConversationStatusRepository conversationStatusRepository,
            PriorityRepository priorityRepository
    ) {
        this.repository = repository;
        this.conversationStatusRepository = conversationStatusRepository;
        this.priorityRepository = priorityRepository;
    }

    public ChatConversationResponse execute(UpdateChatConversationCommand command) {
        var entity = repository.findById(command.id())
                .orElseThrow(() -> new ChatConversationNotFoundApplicationException(command.id().value().toString()));

        entity.update(
                command.conversationStatusId(),
                command.priorityId(),
                command.lastMessageAt(),
                command.closed(),
                command.closedAt(),
                command.closedBy()
        );

        var updated = repository.save(entity);
        return new ChatConversationResponse(
                updated.id().value(),
                updated.conversationStatusId(),
                conversationStatusRepository.findById(new com.backintro.domain.conversationstatus.model.valueobject.ConversationStatusId(updated.conversationStatusId())).map(c -> c.nameStatus()).orElse(null),
                updated.priorityId(),
                priorityRepository.findById(new com.backintro.domain.priority.model.valueobject.PriorityId(updated.priorityId())).map(c -> c.namePriority()).orElse(null),
                updated.lastMessageAt(),
                updated.closed(),
                updated.closedAt(),
                updated.closedBy(),
                null,
                null
        );
    }
}