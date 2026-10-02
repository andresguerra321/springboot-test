package com.backintro.application.phonecontact.usecase;

import com.backintro.application.phonecontact.dto.PhoneContactResponse;
import com.backintro.application.phonecontact.exception.PhoneContactNotFoundApplicationException;
import com.backintro.domain.phonecontact.model.valueobject.PhoneContactId;
import com.backintro.domain.phonecontact.port.repository.PhoneContactRepository;
import com.backintro.domain.contact.port.repository.ContactRepository;

public class GetPhoneContactByIdUseCase {
    private final PhoneContactRepository repository;
    private final ContactRepository contactRepository;

    public GetPhoneContactByIdUseCase(
            PhoneContactRepository repository,
            ContactRepository contactRepository
    ) {
        this.repository = repository;
        this.contactRepository = contactRepository;
    }

    public PhoneContactResponse execute(PhoneContactId id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new PhoneContactNotFoundApplicationException(id.value().toString()));
        return new PhoneContactResponse(
                entity.id().value(),
                entity.contactId(),
                contactRepository.findById(new com.backintro.domain.contact.model.valueobject.ContactId(entity.contactId())).map(c -> c.fullName()).orElse(null),
                entity.phone(),
                entity.notes()
        );
    }
}