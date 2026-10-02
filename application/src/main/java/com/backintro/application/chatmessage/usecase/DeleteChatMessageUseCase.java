package com.backintro.application.chatmessage.usecase;

import java.time.LocalDateTime;

import com.backintro.application.chatmessage.exception.ChatMessageNotFoundApplicationException;
import com.backintro.domain.chatmessage.event.ChatMessageDeletedEvent;
import com.backintro.domain.chatmessage.model.valueobject.ChatMessageId;
import com.backintro.domain.chatmessage.port.repository.ChatMessageRepository;

public class DeleteChatMessageUseCase {
    private final ChatMessageRepository repository;

    public DeleteChatMessageUseCase(ChatMessageRepository repository) {
        this.repository = repository;
    }

    public ChatMessageDeletedEvent execute(ChatMessageId id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new ChatMessageNotFoundApplicationException(id.value().toString()));
        repository.delete(entity);
        return new ChatMessageDeletedEvent(id, LocalDateTime.now());
    }
}