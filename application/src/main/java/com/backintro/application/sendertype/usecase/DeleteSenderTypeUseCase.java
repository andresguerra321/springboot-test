package com.backintro.application.sendertype.usecase;

import java.time.LocalDateTime;

import com.backintro.application.sendertype.exception.SenderTypeNotFoundApplicationException;
import com.backintro.domain.sendertype.event.SenderTypeDeletedEvent;
import com.backintro.domain.sendertype.model.valueobject.SenderTypeId;
import com.backintro.domain.sendertype.port.repository.SenderTypeRepository;

public class DeleteSenderTypeUseCase {
    private final SenderTypeRepository repository;

    public DeleteSenderTypeUseCase(SenderTypeRepository repository) {
        this.repository = repository;
    }

    public SenderTypeDeletedEvent execute(SenderTypeId id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new SenderTypeNotFoundApplicationException(id.value().toString()));
        repository.delete(entity);
        return new SenderTypeDeletedEvent(id, LocalDateTime.now());
    }
}