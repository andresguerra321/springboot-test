package com.backintro.application.chatconversationaisetting.usecase;

import com.backintro.application.chatconversationaisetting.command.UpdateChatConversationAiSettingCommand;
import com.backintro.application.chatconversationaisetting.dto.ChatConversationAiSettingResponse;
import com.backintro.application.chatconversationaisetting.exception.ChatConversationAiSettingNotFoundApplicationException;
import com.backintro.domain.chatconversationaisetting.port.repository.ChatConversationAiSettingRepository;
import com.backintro.domain.aimodel.port.repository.AiModelRepository;

public class UpdateChatConversationAiSettingUseCase {
    private final ChatConversationAiSettingRepository repository;
    private final AiModelRepository aiModelRepository;

    public UpdateChatConversationAiSettingUseCase(
            ChatConversationAiSettingRepository repository,
            AiModelRepository aiModelRepository
    ) {
        this.repository = repository;
        this.aiModelRepository = aiModelRepository;
    }

    public ChatConversationAiSettingResponse execute(UpdateChatConversationAiSettingCommand command) {
        var entity = repository.findById(command.id())
                .orElseThrow(() -> new ChatConversationAiSettingNotFoundApplicationException(command.id().value().toString()));

        entity.update(
                command.conversationId(),
                command.aiEnabled(),
                command.defaultModelId()
        );

        var updated = repository.save(entity);
        return new ChatConversationAiSettingResponse(
                updated.id().value(),
                updated.conversationId(),
                updated.aiEnabled(),
                updated.defaultModelId(),
                updated.defaultModelId() != null ? aiModelRepository.findById(new com.backintro.domain.aimodel.model.valueobject.AiModelId(updated.defaultModelId())).map(c -> c.nameModel()).orElse(null) : null,
                null,
                null
        );
    }
}