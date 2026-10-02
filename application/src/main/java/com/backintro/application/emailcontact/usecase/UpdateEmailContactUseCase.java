package com.backintro.application.emailcontact.usecase;

import com.backintro.application.emailcontact.command.UpdateEmailContactCommand;
import com.backintro.application.emailcontact.dto.EmailContactResponse;
import com.backintro.application.emailcontact.exception.EmailContactNotFoundApplicationException;
import com.backintro.domain.emailcontact.port.repository.EmailContactRepository;
import com.backintro.domain.contact.port.repository.ContactRepository;

public class UpdateEmailContactUseCase {
    private final EmailContactRepository repository;
    private final ContactRepository contactRepository;

    public UpdateEmailContactUseCase(
            EmailContactRepository repository,
            ContactRepository contactRepository
    ) {
        this.repository = repository;
        this.contactRepository = contactRepository;
    }

    public EmailContactResponse execute(UpdateEmailContactCommand command) {
        var entity = repository.findById(command.id())
                .orElseThrow(() -> new EmailContactNotFoundApplicationException(command.id().value().toString()));

        entity.update(
                command.contactId(),
                command.email(),
                command.notes()
        );

        var updated = repository.save(entity);
        return new EmailContactResponse(
                updated.id().value(),
                updated.contactId(),
                contactRepository.findById(new com.backintro.domain.contact.model.valueobject.ContactId(updated.contactId())).map(c -> c.fullName()).orElse(null),
                updated.email(),
                updated.notes(),
                null,
                null
        );
    }
}