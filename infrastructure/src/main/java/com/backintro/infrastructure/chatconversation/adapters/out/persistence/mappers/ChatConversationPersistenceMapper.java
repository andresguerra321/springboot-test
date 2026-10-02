package com.backintro.infrastructure.chatconversation.adapters.out.persistence.mappers;

import com.backintro.domain.chatconversation.model.aggregate.ChatConversation;
import com.backintro.domain.chatconversation.model.valueobject.ChatConversationId;
import com.backintro.infrastructure.chatconversation.adapters.out.persistence.entity.ChatConversationJpaEntity;

public class ChatConversationPersistenceMapper {

    public ChatConversationJpaEntity toJpa(ChatConversation domain) {
        if (domain == null) return null;
        ChatConversationJpaEntity jpa = new ChatConversationJpaEntity();
        jpa.setId(domain.id().value());
        jpa.setConversationStatusId(domain.conversationStatusId());
        jpa.setPriorityId(domain.priorityId());
        jpa.setLastMessageAt(domain.lastMessageAt());
        jpa.setClosed(domain.closed());
        jpa.setClosedAt(domain.closedAt());
        jpa.setClosedBy(domain.closedBy());
        return jpa;
    }

    public ChatConversation toDomain(ChatConversationJpaEntity jpa) {
        if (jpa == null) return null;
        return ChatConversation.restore(
                new ChatConversationId(jpa.getId()),
                jpa.getConversationStatusId(),
                jpa.getPriorityId(),
                jpa.getLastMessageAt(),
                jpa.isClosed(),
                jpa.getClosedAt(),
                jpa.getClosedBy()
        );
    }
}