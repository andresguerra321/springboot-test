package com.backintro.application.messagetype.usecase;

import java.time.LocalDateTime;

import com.backintro.application.messagetype.exception.MessageTypeNotFoundApplicationException;
import com.backintro.domain.messagetype.event.MessageTypeDeletedEvent;
import com.backintro.domain.messagetype.model.valueobject.MessageTypeId;
import com.backintro.domain.messagetype.port.repository.MessageTypeRepository;

public class DeleteMessageTypeUseCase {
    private final MessageTypeRepository repository;

    public DeleteMessageTypeUseCase(MessageTypeRepository repository) {
        this.repository = repository;
    }

    public MessageTypeDeletedEvent execute(MessageTypeId id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new MessageTypeNotFoundApplicationException(id.value().toString()));
        repository.delete(entity);
        return new MessageTypeDeletedEvent(id, LocalDateTime.now());
    }
}