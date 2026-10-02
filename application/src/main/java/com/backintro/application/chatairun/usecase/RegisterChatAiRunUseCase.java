package com.backintro.application.chatairun.usecase;

import com.backintro.application.chatairun.command.RegisterChatAiRunCommand;
import com.backintro.application.chatairun.dto.ChatAiRunResponse;
import com.backintro.domain.chatairun.model.aggregate.ChatAiRun;
import com.backintro.domain.chatairun.port.repository.ChatAiRunRepository;
import com.backintro.domain.aimodel.port.repository.AiModelRepository;
import com.backintro.domain.airunstatus.port.repository.AiRunStatusRepository;

public class RegisterChatAiRunUseCase {
    private final ChatAiRunRepository repository;
    private final AiModelRepository aiModelRepository;
    private final AiRunStatusRepository aiRunStatusRepository;

    public RegisterChatAiRunUseCase(
            ChatAiRunRepository repository,
            AiModelRepository aiModelRepository,
            AiRunStatusRepository aiRunStatusRepository
    ) {
        this.repository = repository;
        this.aiModelRepository = aiModelRepository;
        this.aiRunStatusRepository = aiRunStatusRepository;
    }

    public ChatAiRunResponse execute(RegisterChatAiRunCommand command) {
        ChatAiRun entity = ChatAiRun.register(
                command.conversationId(),
                command.messageId(),
                command.modelId(),
                command.aiRunStatusId()
        );
        ChatAiRun saved = repository.save(entity);
        return new ChatAiRunResponse(
                saved.id().value(),
                saved.conversationId(),
                saved.messageId(),
                saved.modelId(),
                aiModelRepository.findById(new com.backintro.domain.aimodel.model.valueobject.AiModelId(saved.modelId())).map(c -> c.nameModel()).orElse(null),
                saved.aiRunStatusId(),
                aiRunStatusRepository.findById(new com.backintro.domain.airunstatus.model.valueobject.AiRunStatusId(saved.aiRunStatusId())).map(c -> c.nameStatus()).orElse(null),
                null,
                null
        );
    }
}