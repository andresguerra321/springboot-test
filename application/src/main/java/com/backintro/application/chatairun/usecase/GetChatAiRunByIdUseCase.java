package com.backintro.application.chatairun.usecase;

import com.backintro.application.chatairun.dto.ChatAiRunResponse;
import com.backintro.application.chatairun.exception.ChatAiRunNotFoundApplicationException;
import com.backintro.domain.chatairun.model.valueobject.ChatAiRunId;
import com.backintro.domain.chatairun.port.repository.ChatAiRunRepository;
import com.backintro.domain.aimodel.port.repository.AiModelRepository;
import com.backintro.domain.airunstatus.port.repository.AiRunStatusRepository;

public class GetChatAiRunByIdUseCase {
    private final ChatAiRunRepository repository;
    private final AiModelRepository aiModelRepository;
    private final AiRunStatusRepository aiRunStatusRepository;

    public GetChatAiRunByIdUseCase(
            ChatAiRunRepository repository,
            AiModelRepository aiModelRepository,
            AiRunStatusRepository aiRunStatusRepository
    ) {
        this.repository = repository;
        this.aiModelRepository = aiModelRepository;
        this.aiRunStatusRepository = aiRunStatusRepository;
    }

    public ChatAiRunResponse execute(ChatAiRunId id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new ChatAiRunNotFoundApplicationException(id.value().toString()));
        return new ChatAiRunResponse(
                entity.id().value(),
                entity.conversationId(),
                entity.messageId(),
                entity.modelId(),
                aiModelRepository.findById(new com.backintro.domain.aimodel.model.valueobject.AiModelId(entity.modelId())).map(c -> c.nameModel()).orElse(null),
                entity.aiRunStatusId(),
                aiRunStatusRepository.findById(new com.backintro.domain.airunstatus.model.valueobject.AiRunStatusId(entity.aiRunStatusId())).map(c -> c.nameStatus()).orElse(null),
                null,
                null
        );
    }
}