package com.backintro.application.contact.usecase;

import java.time.LocalDateTime;

import com.backintro.application.contact.exception.ContactNotFoundApplicationException;
import com.backintro.domain.contact.event.ContactDeletedEvent;
import com.backintro.domain.contact.model.valueobject.ContactId;
import com.backintro.domain.contact.port.repository.ContactRepository;

public class DeleteContactUseCase {
    private final ContactRepository repository;

    public DeleteContactUseCase(ContactRepository repository) {
        this.repository = repository;
    }

    public ContactDeletedEvent execute(ContactId id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new ContactNotFoundApplicationException(id.value().toString()));
        repository.delete(entity);
        return new ContactDeletedEvent(id, LocalDateTime.now());
    }
}