package com.backintro.application.chatairun.usecase;

import java.util.List;

import com.backintro.application.chatairun.dto.ChatAiRunResponse;
import com.backintro.domain.chatairun.port.repository.ChatAiRunRepository;
import com.backintro.domain.aimodel.port.repository.AiModelRepository;
import com.backintro.domain.airunstatus.port.repository.AiRunStatusRepository;

public class ListChatAiRunUseCase {
    private final ChatAiRunRepository repository;
    private final AiModelRepository aiModelRepository;
    private final AiRunStatusRepository aiRunStatusRepository;

    public ListChatAiRunUseCase(
            ChatAiRunRepository repository,
            AiModelRepository aiModelRepository,
            AiRunStatusRepository aiRunStatusRepository
    ) {
        this.repository = repository;
        this.aiModelRepository = aiModelRepository;
        this.aiRunStatusRepository = aiRunStatusRepository;
    }

    public List<ChatAiRunResponse> execute() {
        return repository.findAll()
                .stream()
                .map(entity -> new ChatAiRunResponse(
                entity.id().value(),
                entity.conversationId(),
                entity.messageId(),
                entity.modelId(),
                aiModelRepository.findById(new com.backintro.domain.aimodel.model.valueobject.AiModelId(entity.modelId())).map(c -> c.nameModel()).orElse(null),
                entity.aiRunStatusId(),
                aiRunStatusRepository.findById(new com.backintro.domain.airunstatus.model.valueobject.AiRunStatusId(entity.aiRunStatusId())).map(c -> c.nameStatus()).orElse(null),
                null,
                null
                ))
                .toList();
    }
}