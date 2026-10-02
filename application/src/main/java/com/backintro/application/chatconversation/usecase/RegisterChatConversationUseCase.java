package com.backintro.application.chatconversation.usecase;

import com.backintro.application.chatconversation.command.RegisterChatConversationCommand;
import com.backintro.application.chatconversation.dto.ChatConversationResponse;
import com.backintro.domain.chatconversation.model.aggregate.ChatConversation;
import com.backintro.domain.chatconversation.port.repository.ChatConversationRepository;
import com.backintro.domain.conversationstatus.port.repository.ConversationStatusRepository;
import com.backintro.domain.priority.port.repository.PriorityRepository;

public class RegisterChatConversationUseCase {
    private final ChatConversationRepository repository;
    private final ConversationStatusRepository conversationStatusRepository;
    private final PriorityRepository priorityRepository;

    public RegisterChatConversationUseCase(
            ChatConversationRepository repository,
            ConversationStatusRepository conversationStatusRepository,
            PriorityRepository priorityRepository
    ) {
        this.repository = repository;
        this.conversationStatusRepository = conversationStatusRepository;
        this.priorityRepository = priorityRepository;
    }

    public ChatConversationResponse execute(RegisterChatConversationCommand command) {
        ChatConversation entity = ChatConversation.register(
                command.conversationStatusId(),
                command.priorityId(),
                command.lastMessageAt(),
                command.closed(),
                command.closedAt(),
                command.closedBy()
        );
        ChatConversation saved = repository.save(entity);
        return new ChatConversationResponse(
                saved.id().value(),
                saved.conversationStatusId(),
                conversationStatusRepository.findById(new com.backintro.domain.conversationstatus.model.valueobject.ConversationStatusId(saved.conversationStatusId())).map(c -> c.nameStatus()).orElse(null),
                saved.priorityId(),
                priorityRepository.findById(new com.backintro.domain.priority.model.valueobject.PriorityId(saved.priorityId())).map(c -> c.namePriority()).orElse(null),
                saved.lastMessageAt(),
                saved.closed(),
                saved.closedAt(),
                saved.closedBy(),
                null,
                null
        );
    }
}