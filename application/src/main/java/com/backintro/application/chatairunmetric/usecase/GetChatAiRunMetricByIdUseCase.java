package com.backintro.application.chatairunmetric.usecase;

import com.backintro.application.chatairunmetric.dto.ChatAiRunMetricResponse;
import com.backintro.application.chatairunmetric.exception.ChatAiRunMetricNotFoundApplicationException;
import com.backintro.domain.chatairunmetric.model.valueobject.ChatAiRunMetricId;
import com.backintro.domain.chatairunmetric.port.repository.ChatAiRunMetricRepository;

public class GetChatAiRunMetricByIdUseCase {
    private final ChatAiRunMetricRepository repository;

    public GetChatAiRunMetricByIdUseCase(
            ChatAiRunMetricRepository repository
    ) {
        this.repository = repository;
    }

    public ChatAiRunMetricResponse execute(ChatAiRunMetricId id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new ChatAiRunMetricNotFoundApplicationException(id.value().toString()));
        return new ChatAiRunMetricResponse(
                entity.id().value(),
                entity.aiRunId(),
                entity.promptTokens(),
                entity.completionTokens(),
                entity.totalTokens(),
                entity.cost(),
                null
        );
    }
}