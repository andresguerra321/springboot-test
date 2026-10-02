package com.backintro.application.contact.usecase;

import com.backintro.application.contact.command.RegisterContactCommand;
import com.backintro.application.contact.dto.ContactResponse;
import com.backintro.domain.contact.model.aggregate.Contact;
import com.backintro.domain.contact.port.repository.ContactRepository;
import com.backintro.domain.citymunicipality.port.repository.CityMunicipalityRepository;

public class RegisterContactUseCase {
    private final ContactRepository repository;
    private final CityMunicipalityRepository cityMunicipalityRepository;

    public RegisterContactUseCase(
            ContactRepository repository,
            CityMunicipalityRepository cityMunicipalityRepository
    ) {
        this.repository = repository;
        this.cityMunicipalityRepository = cityMunicipalityRepository;
    }

    public ContactResponse execute(RegisterContactCommand command) {
        Contact entity = Contact.register(
                command.fullName(),
                command.email(),
                command.notes(),
                command.cityId(),
                command.createdBy(),
                command.updatedBy()
        );
        Contact saved = repository.save(entity);
        return new ContactResponse(
                saved.id().value(),
                saved.fullName(),
                saved.email(),
                saved.notes(),
                saved.cityId(),
                saved.cityId() != null ? cityMunicipalityRepository.findById(new com.backintro.domain.citymunicipality.model.valueobject.CityMunicipalityId(saved.cityId())).map(c -> c.name()).orElse(null) : null,
                saved.createdBy(),
                saved.updatedBy(),
                null,
                null
        );
    }
}