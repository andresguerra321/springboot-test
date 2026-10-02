package com.backintro.application.phonecontact.usecase;

import java.util.List;

import com.backintro.application.phonecontact.dto.PhoneContactResponse;
import com.backintro.domain.phonecontact.port.repository.PhoneContactRepository;
import com.backintro.domain.contact.port.repository.ContactRepository;

public class ListPhoneContactUseCase {
    private final PhoneContactRepository repository;
    private final ContactRepository contactRepository;

    public ListPhoneContactUseCase(
            PhoneContactRepository repository,
            ContactRepository contactRepository
    ) {
        this.repository = repository;
        this.contactRepository = contactRepository;
    }

    public List<PhoneContactResponse> execute() {
        return repository.findAll()
                .stream()
                .map(entity -> new PhoneContactResponse(
                entity.id().value(),
                entity.contactId(),
                contactRepository.findById(new com.backintro.domain.contact.model.valueobject.ContactId(entity.contactId())).map(c -> c.fullName()).orElse(null),
                entity.phone(),
                entity.notes()
                ))
                .toList();
    }
}