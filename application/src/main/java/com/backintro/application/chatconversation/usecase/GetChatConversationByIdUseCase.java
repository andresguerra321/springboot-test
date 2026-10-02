package com.backintro.application.chatconversation.usecase;

import com.backintro.application.chatconversation.dto.ChatConversationResponse;
import com.backintro.application.chatconversation.exception.ChatConversationNotFoundApplicationException;
import com.backintro.domain.chatconversation.model.valueobject.ChatConversationId;
import com.backintro.domain.chatconversation.port.repository.ChatConversationRepository;
import com.backintro.domain.conversationstatus.port.repository.ConversationStatusRepository;
import com.backintro.domain.priority.port.repository.PriorityRepository;

public class GetChatConversationByIdUseCase {
    private final ChatConversationRepository repository;
    private final ConversationStatusRepository conversationStatusRepository;
    private final PriorityRepository priorityRepository;

    public GetChatConversationByIdUseCase(
            ChatConversationRepository repository,
            ConversationStatusRepository conversationStatusRepository,
            PriorityRepository priorityRepository
    ) {
        this.repository = repository;
        this.conversationStatusRepository = conversationStatusRepository;
        this.priorityRepository = priorityRepository;
    }

    public ChatConversationResponse execute(ChatConversationId id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new ChatConversationNotFoundApplicationException(id.value().toString()));
        return new ChatConversationResponse(
                entity.id().value(),
                entity.conversationStatusId(),
                conversationStatusRepository.findById(new com.backintro.domain.conversationstatus.model.valueobject.ConversationStatusId(entity.conversationStatusId())).map(c -> c.nameStatus()).orElse(null),
                entity.priorityId(),
                priorityRepository.findById(new com.backintro.domain.priority.model.valueobject.PriorityId(entity.priorityId())).map(c -> c.namePriority()).orElse(null),
                entity.lastMessageAt(),
                entity.closed(),
                entity.closedAt(),
                entity.closedBy(),
                null,
                null
        );
    }
}