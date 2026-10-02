package com.backintro.application.emailcontact.usecase;

import java.util.List;

import com.backintro.application.emailcontact.dto.EmailContactResponse;
import com.backintro.domain.emailcontact.port.repository.EmailContactRepository;
import com.backintro.domain.contact.port.repository.ContactRepository;

public class ListEmailContactUseCase {
    private final EmailContactRepository repository;
    private final ContactRepository contactRepository;

    public ListEmailContactUseCase(
            EmailContactRepository repository,
            ContactRepository contactRepository
    ) {
        this.repository = repository;
        this.contactRepository = contactRepository;
    }

    public List<EmailContactResponse> execute() {
        return repository.findAll()
                .stream()
                .map(entity -> new EmailContactResponse(
                entity.id().value(),
                entity.contactId(),
                contactRepository.findById(new com.backintro.domain.contact.model.valueobject.ContactId(entity.contactId())).map(c -> c.fullName()).orElse(null),
                entity.email(),
                entity.notes(),
                null,
                null
                ))
                .toList();
    }
}