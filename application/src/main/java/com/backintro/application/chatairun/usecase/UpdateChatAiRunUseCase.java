package com.backintro.application.chatairun.usecase;

import com.backintro.application.chatairun.command.UpdateChatAiRunCommand;
import com.backintro.application.chatairun.dto.ChatAiRunResponse;
import com.backintro.application.chatairun.exception.ChatAiRunNotFoundApplicationException;
import com.backintro.domain.chatairun.port.repository.ChatAiRunRepository;
import com.backintro.domain.aimodel.port.repository.AiModelRepository;
import com.backintro.domain.airunstatus.port.repository.AiRunStatusRepository;

public class UpdateChatAiRunUseCase {
    private final ChatAiRunRepository repository;
    private final AiModelRepository aiModelRepository;
    private final AiRunStatusRepository aiRunStatusRepository;

    public UpdateChatAiRunUseCase(
            ChatAiRunRepository repository,
            AiModelRepository aiModelRepository,
            AiRunStatusRepository aiRunStatusRepository
    ) {
        this.repository = repository;
        this.aiModelRepository = aiModelRepository;
        this.aiRunStatusRepository = aiRunStatusRepository;
    }

    public ChatAiRunResponse execute(UpdateChatAiRunCommand command) {
        var entity = repository.findById(command.id())
                .orElseThrow(() -> new ChatAiRunNotFoundApplicationException(command.id().value().toString()));

        entity.update(
                command.conversationId(),
                command.messageId(),
                command.modelId(),
                command.aiRunStatusId()
        );

        var updated = repository.save(entity);
        return new ChatAiRunResponse(
                updated.id().value(),
                updated.conversationId(),
                updated.messageId(),
                updated.modelId(),
                aiModelRepository.findById(new com.backintro.domain.aimodel.model.valueobject.AiModelId(updated.modelId())).map(c -> c.nameModel()).orElse(null),
                updated.aiRunStatusId(),
                aiRunStatusRepository.findById(new com.backintro.domain.airunstatus.model.valueobject.AiRunStatusId(updated.aiRunStatusId())).map(c -> c.nameStatus()).orElse(null),
                null,
                null
        );
    }
}