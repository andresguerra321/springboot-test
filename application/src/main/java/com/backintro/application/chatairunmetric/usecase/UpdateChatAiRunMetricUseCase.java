package com.backintro.application.chatairunmetric.usecase;

import com.backintro.application.chatairunmetric.command.UpdateChatAiRunMetricCommand;
import com.backintro.application.chatairunmetric.dto.ChatAiRunMetricResponse;
import com.backintro.application.chatairunmetric.exception.ChatAiRunMetricNotFoundApplicationException;
import com.backintro.domain.chatairunmetric.port.repository.ChatAiRunMetricRepository;

public class UpdateChatAiRunMetricUseCase {
    private final ChatAiRunMetricRepository repository;

    public UpdateChatAiRunMetricUseCase(
            ChatAiRunMetricRepository repository
    ) {
        this.repository = repository;
    }

    public ChatAiRunMetricResponse execute(UpdateChatAiRunMetricCommand command) {
        var entity = repository.findById(command.id())
                .orElseThrow(() -> new ChatAiRunMetricNotFoundApplicationException(command.id().value().toString()));

        entity.update(
                command.aiRunId(),
                command.promptTokens(),
                command.completionTokens(),
                command.totalTokens(),
                command.cost()
        );

        var updated = repository.save(entity);
        return new ChatAiRunMetricResponse(
                updated.id().value(),
                updated.aiRunId(),
                updated.promptTokens(),
                updated.completionTokens(),
                updated.totalTokens(),
                updated.cost(),
                null
        );
    }
}