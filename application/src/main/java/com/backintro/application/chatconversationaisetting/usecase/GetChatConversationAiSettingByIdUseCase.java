package com.backintro.application.chatconversationaisetting.usecase;

import com.backintro.application.chatconversationaisetting.dto.ChatConversationAiSettingResponse;
import com.backintro.application.chatconversationaisetting.exception.ChatConversationAiSettingNotFoundApplicationException;
import com.backintro.domain.chatconversationaisetting.model.valueobject.ChatConversationAiSettingId;
import com.backintro.domain.chatconversationaisetting.port.repository.ChatConversationAiSettingRepository;
import com.backintro.domain.aimodel.port.repository.AiModelRepository;

public class GetChatConversationAiSettingByIdUseCase {
    private final ChatConversationAiSettingRepository repository;
    private final AiModelRepository aiModelRepository;

    public GetChatConversationAiSettingByIdUseCase(
            ChatConversationAiSettingRepository repository,
            AiModelRepository aiModelRepository
    ) {
        this.repository = repository;
        this.aiModelRepository = aiModelRepository;
    }

    public ChatConversationAiSettingResponse execute(ChatConversationAiSettingId id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new ChatConversationAiSettingNotFoundApplicationException(id.value().toString()));
        return new ChatConversationAiSettingResponse(
                entity.id().value(),
                entity.conversationId(),
                entity.aiEnabled(),
                entity.defaultModelId(),
                entity.defaultModelId() != null ? aiModelRepository.findById(new com.backintro.domain.aimodel.model.valueobject.AiModelId(entity.defaultModelId())).map(c -> c.nameModel()).orElse(null) : null,
                null,
                null
        );
    }
}