package com.backintro.domain.chatconversationaisetting.port.repository;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.chatconversationaisetting.model.aggregate.ChatConversationAiSetting;
import com.backintro.domain.chatconversationaisetting.model.valueobject.ChatConversationAiSettingId;

public interface ChatConversationAiSettingRepository {
    ChatConversationAiSetting save(ChatConversationAiSetting entity);
    Optional<ChatConversationAiSetting> findById(ChatConversationAiSettingId id);
    List<ChatConversationAiSetting> findAll();
    void delete(ChatConversationAiSetting entity);
}