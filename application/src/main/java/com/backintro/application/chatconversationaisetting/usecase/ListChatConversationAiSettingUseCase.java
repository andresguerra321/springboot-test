package com.backintro.application.chatconversationaisetting.usecase;

import java.util.List;

import com.backintro.application.chatconversationaisetting.dto.ChatConversationAiSettingResponse;
import com.backintro.domain.chatconversationaisetting.port.repository.ChatConversationAiSettingRepository;
import com.backintro.domain.aimodel.port.repository.AiModelRepository;

public class ListChatConversationAiSettingUseCase {
    private final ChatConversationAiSettingRepository repository;
    private final AiModelRepository aiModelRepository;

    public ListChatConversationAiSettingUseCase(
            ChatConversationAiSettingRepository repository,
            AiModelRepository aiModelRepository
    ) {
        this.repository = repository;
        this.aiModelRepository = aiModelRepository;
    }

    public List<ChatConversationAiSettingResponse> execute() {
        return repository.findAll()
                .stream()
                .map(entity -> new ChatConversationAiSettingResponse(
                entity.id().value(),
                entity.conversationId(),
                entity.aiEnabled(),
                entity.defaultModelId(),
                entity.defaultModelId() != null ? aiModelRepository.findById(new com.backintro.domain.aimodel.model.valueobject.AiModelId(entity.defaultModelId())).map(c -> c.nameModel()).orElse(null) : null,
                null,
                null
                ))
                .toList();
    }
}