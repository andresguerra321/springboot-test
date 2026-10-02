package com.backintro.application.chatconversation.usecase;

import java.util.List;

import com.backintro.application.chatconversation.dto.ChatConversationResponse;
import com.backintro.domain.chatconversation.port.repository.ChatConversationRepository;
import com.backintro.domain.conversationstatus.port.repository.ConversationStatusRepository;
import com.backintro.domain.priority.port.repository.PriorityRepository;

public class ListChatConversationUseCase {
    private final ChatConversationRepository repository;
    private final ConversationStatusRepository conversationStatusRepository;
    private final PriorityRepository priorityRepository;

    public ListChatConversationUseCase(
            ChatConversationRepository repository,
            ConversationStatusRepository conversationStatusRepository,
            PriorityRepository priorityRepository
    ) {
        this.repository = repository;
        this.conversationStatusRepository = conversationStatusRepository;
        this.priorityRepository = priorityRepository;
    }

    public List<ChatConversationResponse> execute() {
        return repository.findAll()
                .stream()
                .map(entity -> new ChatConversationResponse(
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
                ))
                .toList();
    }
}