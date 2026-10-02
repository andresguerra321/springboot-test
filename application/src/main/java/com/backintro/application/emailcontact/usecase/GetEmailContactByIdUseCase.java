package com.backintro.application.emailcontact.usecase;

import com.backintro.application.emailcontact.dto.EmailContactResponse;
import com.backintro.application.emailcontact.exception.EmailContactNotFoundApplicationException;
import com.backintro.domain.emailcontact.model.valueobject.EmailContactId;
import com.backintro.domain.emailcontact.port.repository.EmailContactRepository;
import com.backintro.domain.contact.port.repository.ContactRepository;

public class GetEmailContactByIdUseCase {
    private final EmailContactRepository repository;
    private final ContactRepository contactRepository;

    public GetEmailContactByIdUseCase(
            EmailContactRepository repository,
            ContactRepository contactRepository
    ) {
        this.repository = repository;
        this.contactRepository = contactRepository;
    }

    public EmailContactResponse execute(EmailContactId id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new EmailContactNotFoundApplicationException(id.value().toString()));
        return new EmailContactResponse(
                entity.id().value(),
                entity.contactId(),
                contactRepository.findById(new com.backintro.domain.contact.model.valueobject.ContactId(entity.contactId())).map(c -> c.fullName()).orElse(null),
                entity.email(),
                entity.notes(),
                null,
                null
        );
    }
}