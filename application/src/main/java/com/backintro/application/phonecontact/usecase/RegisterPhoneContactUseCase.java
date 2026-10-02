package com.backintro.application.phonecontact.usecase;

import com.backintro.application.phonecontact.command.RegisterPhoneContactCommand;
import com.backintro.application.phonecontact.dto.PhoneContactResponse;
import com.backintro.domain.phonecontact.model.aggregate.PhoneContact;
import com.backintro.domain.phonecontact.port.repository.PhoneContactRepository;
import com.backintro.domain.contact.port.repository.ContactRepository;

public class RegisterPhoneContactUseCase {
    private final PhoneContactRepository repository;
    private final ContactRepository contactRepository;

    public RegisterPhoneContactUseCase(
            PhoneContactRepository repository,
            ContactRepository contactRepository
    ) {
        this.repository = repository;
        this.contactRepository = contactRepository;
    }

    public PhoneContactResponse execute(RegisterPhoneContactCommand command) {
        PhoneContact entity = PhoneContact.register(
                command.contactId(),
                command.phone(),
                command.notes()
        );
        PhoneContact saved = repository.save(entity);
        return new PhoneContactResponse(
                saved.id().value(),
                saved.contactId(),
                contactRepository.findById(new com.backintro.domain.contact.model.valueobject.ContactId(saved.contactId())).map(c -> c.fullName()).orElse(null),
                saved.phone(),
                saved.notes()
        );
    }
}