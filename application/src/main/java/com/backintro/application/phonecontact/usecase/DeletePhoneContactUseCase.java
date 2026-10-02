package com.backintro.application.phonecontact.usecase;

import java.time.LocalDateTime;

import com.backintro.application.phonecontact.exception.PhoneContactNotFoundApplicationException;
import com.backintro.domain.phonecontact.event.PhoneContactDeletedEvent;
import com.backintro.domain.phonecontact.model.valueobject.PhoneContactId;
import com.backintro.domain.phonecontact.port.repository.PhoneContactRepository;

public class DeletePhoneContactUseCase {
    private final PhoneContactRepository repository;

    public DeletePhoneContactUseCase(PhoneContactRepository repository) {
        this.repository = repository;
    }

    public PhoneContactDeletedEvent execute(PhoneContactId id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new PhoneContactNotFoundApplicationException(id.value().toString()));
        repository.delete(entity);
        return new PhoneContactDeletedEvent(id, LocalDateTime.now());
    }
}