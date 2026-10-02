package com.backintro.application.emailcontact.usecase;

import java.time.LocalDateTime;

import com.backintro.application.emailcontact.exception.EmailContactNotFoundApplicationException;
import com.backintro.domain.emailcontact.event.EmailContactDeletedEvent;
import com.backintro.domain.emailcontact.model.valueobject.EmailContactId;
import com.backintro.domain.emailcontact.port.repository.EmailContactRepository;

public class DeleteEmailContactUseCase {
    private final EmailContactRepository repository;

    public DeleteEmailContactUseCase(EmailContactRepository repository) {
        this.repository = repository;
    }

    public EmailContactDeletedEvent execute(EmailContactId id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new EmailContactNotFoundApplicationException(id.value().toString()));
        repository.delete(entity);
        return new EmailContactDeletedEvent(id, LocalDateTime.now());
    }
}