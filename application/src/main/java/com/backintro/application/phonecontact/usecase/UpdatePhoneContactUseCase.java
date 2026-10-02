package com.backintro.application.phonecontact.usecase;

import com.backintro.application.phonecontact.command.UpdatePhoneContactCommand;
import com.backintro.application.phonecontact.dto.PhoneContactResponse;
import com.backintro.application.phonecontact.exception.PhoneContactNotFoundApplicationException;
import com.backintro.domain.phonecontact.port.repository.PhoneContactRepository;
import com.backintro.domain.contact.port.repository.ContactRepository;

public class UpdatePhoneContactUseCase {
    private final PhoneContactRepository repository;
    private final ContactRepository contactRepository;

    public UpdatePhoneContactUseCase(
            PhoneContactRepository repository,
            ContactRepository contactRepository
    ) {
        this.repository = repository;
        this.contactRepository = contactRepository;
    }

    public PhoneContactResponse execute(UpdatePhoneContactCommand command) {
        var entity = repository.findById(command.id())
                .orElseThrow(() -> new PhoneContactNotFoundApplicationException(command.id().value().toString()));

        entity.update(
                command.contactId(),
                command.phone(),
                command.notes()
        );

        var updated = repository.save(entity);
        return new PhoneContactResponse(
                updated.id().value(),
                updated.contactId(),
                contactRepository.findById(new com.backintro.domain.contact.model.valueobject.ContactId(updated.contactId())).map(c -> c.fullName()).orElse(null),
                updated.phone(),
                updated.notes()
        );
    }
}