package com.backintro.application.chatairun.usecase;

import java.time.LocalDateTime;

import com.backintro.application.chatairun.exception.ChatAiRunNotFoundApplicationException;
import com.backintro.domain.chatairun.event.ChatAiRunDeletedEvent;
import com.backintro.domain.chatairun.model.valueobject.ChatAiRunId;
import com.backintro.domain.chatairun.port.repository.ChatAiRunRepository;

public class DeleteChatAiRunUseCase {
    private final ChatAiRunRepository repository;

    public DeleteChatAiRunUseCase(ChatAiRunRepository repository) {
        this.repository = repository;
    }

    public ChatAiRunDeletedEvent execute(ChatAiRunId id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new ChatAiRunNotFoundApplicationException(id.value().toString()));
        repository.delete(entity);
        return new ChatAiRunDeletedEvent(id, LocalDateTime.now());
    }
}