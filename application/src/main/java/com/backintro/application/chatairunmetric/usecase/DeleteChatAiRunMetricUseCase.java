package com.backintro.application.chatairunmetric.usecase;

import java.time.LocalDateTime;

import com.backintro.application.chatairunmetric.exception.ChatAiRunMetricNotFoundApplicationException;
import com.backintro.domain.chatairunmetric.event.ChatAiRunMetricDeletedEvent;
import com.backintro.domain.chatairunmetric.model.valueobject.ChatAiRunMetricId;
import com.backintro.domain.chatairunmetric.port.repository.ChatAiRunMetricRepository;

public class DeleteChatAiRunMetricUseCase {
    private final ChatAiRunMetricRepository repository;

    public DeleteChatAiRunMetricUseCase(ChatAiRunMetricRepository repository) {
        this.repository = repository;
    }

    public ChatAiRunMetricDeletedEvent execute(ChatAiRunMetricId id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new ChatAiRunMetricNotFoundApplicationException(id.value().toString()));
        repository.delete(entity);
        return new ChatAiRunMetricDeletedEvent(id, LocalDateTime.now());
    }
}