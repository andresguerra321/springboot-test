package com.backintro.application.chatairunerror.usecase;

import java.time.LocalDateTime;

import com.backintro.application.chatairunerror.exception.ChatAiRunErrorNotFoundApplicationException;
import com.backintro.domain.chatairunerror.event.ChatAiRunErrorDeletedEvent;
import com.backintro.domain.chatairunerror.model.valueobject.ChatAiRunErrorId;
import com.backintro.domain.chatairunerror.port.repository.ChatAiRunErrorRepository;

public class DeleteChatAiRunErrorUseCase {
    private final ChatAiRunErrorRepository repository;

    public DeleteChatAiRunErrorUseCase(ChatAiRunErrorRepository repository) {
        this.repository = repository;
    }

    public ChatAiRunErrorDeletedEvent execute(ChatAiRunErrorId id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new ChatAiRunErrorNotFoundApplicationException(id.value().toString()));
        repository.delete(entity);
        return new ChatAiRunErrorDeletedEvent(id, LocalDateTime.now());
    }
}