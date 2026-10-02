package com.backintro.application.emailcontact.usecase;

import com.backintro.application.emailcontact.command.RegisterEmailContactCommand;
import com.backintro.application.emailcontact.dto.EmailContactResponse;
import com.backintro.domain.emailcontact.model.aggregate.EmailContact;
import com.backintro.domain.emailcontact.port.repository.EmailContactRepository;
import com.backintro.domain.contact.port.repository.ContactRepository;

public class RegisterEmailContactUseCase {
    private final EmailContactRepository repository;
    private final ContactRepository contactRepository;

    public RegisterEmailContactUseCase(
            EmailContactRepository repository,
            ContactRepository contactRepository
    ) {
        this.repository = repository;
        this.contactRepository = contactRepository;
    }

    public EmailContactResponse execute(RegisterEmailContactCommand command) {
        EmailContact entity = EmailContact.register(
                command.contactId(),
                command.email(),
                command.notes()
        );
        EmailContact saved = repository.save(entity);
        return new EmailContactResponse(
                saved.id().value(),
                saved.contactId(),
                contactRepository.findById(new com.backintro.domain.contact.model.valueobject.ContactId(saved.contactId())).map(c -> c.fullName()).orElse(null),
                saved.email(),
                saved.notes(),
                null,
                null
        );
    }
}