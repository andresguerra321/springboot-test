package com.backintro.application.chatconversationaisetting.usecase;

import com.backintro.application.chatconversationaisetting.command.RegisterChatConversationAiSettingCommand;
import com.backintro.application.chatconversationaisetting.dto.ChatConversationAiSettingResponse;
import com.backintro.domain.chatconversationaisetting.model.aggregate.ChatConversationAiSetting;
import com.backintro.domain.chatconversationaisetting.port.repository.ChatConversationAiSettingRepository;
import com.backintro.domain.aimodel.port.repository.AiModelRepository;

public class RegisterChatConversationAiSettingUseCase {
    private final ChatConversationAiSettingRepository repository;
    private final AiModelRepository aiModelRepository;

    public RegisterChatConversationAiSettingUseCase(
            ChatConversationAiSettingRepository repository,
            AiModelRepository aiModelRepository
    ) {
        this.repository = repository;
        this.aiModelRepository = aiModelRepository;
    }

    public ChatConversationAiSettingResponse execute(RegisterChatConversationAiSettingCommand command) {
        ChatConversationAiSetting entity = ChatConversationAiSetting.register(
                command.conversationId(),
                command.aiEnabled(),
                command.defaultModelId()
        );
        ChatConversationAiSetting saved = repository.save(entity);
        return new ChatConversationAiSettingResponse(
                saved.id().value(),
                saved.conversationId(),
                saved.aiEnabled(),
                saved.defaultModelId(),
                saved.defaultModelId() != null ? aiModelRepository.findById(new com.backintro.domain.aimodel.model.valueobject.AiModelId(saved.defaultModelId())).map(c -> c.nameModel()).orElse(null) : null,
                null,
                null
        );
    }
}