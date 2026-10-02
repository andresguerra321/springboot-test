package com.backintro.infrastructure.chatconversationaisetting.adapters.out.persistence.mappers;

import com.backintro.domain.chatconversationaisetting.model.aggregate.ChatConversationAiSetting;
import com.backintro.domain.chatconversationaisetting.model.valueobject.ChatConversationAiSettingId;
import com.backintro.infrastructure.chatconversationaisetting.adapters.out.persistence.entity.ChatConversationAiSettingJpaEntity;

public class ChatConversationAiSettingPersistenceMapper {

    public ChatConversationAiSettingJpaEntity toJpa(ChatConversationAiSetting domain) {
        if (domain == null) return null;
        ChatConversationAiSettingJpaEntity jpa = new ChatConversationAiSettingJpaEntity();
        jpa.setId(domain.id().value());
        jpa.setConversationId(domain.conversationId());
        jpa.setAiEnabled(domain.aiEnabled());
        jpa.setDefaultModelId(domain.defaultModelId());
        return jpa;
    }

    public ChatConversationAiSetting toDomain(ChatConversationAiSettingJpaEntity jpa) {
        if (jpa == null) return null;
        return ChatConversationAiSetting.restore(
                new ChatConversationAiSettingId(jpa.getId()),
                jpa.getConversationId(),
                jpa.isAiEnabled(),
                jpa.getDefaultModelId()
        );
    }
}