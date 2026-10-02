package com.backintro.application.contact.usecase;

import com.backintro.application.contact.command.UpdateContactCommand;
import com.backintro.application.contact.dto.ContactResponse;
import com.backintro.application.contact.exception.ContactNotFoundApplicationException;
import com.backintro.domain.contact.port.repository.ContactRepository;
import com.backintro.domain.citymunicipality.port.repository.CityMunicipalityRepository;

public class UpdateContactUseCase {
    private final ContactRepository repository;
    private final CityMunicipalityRepository cityMunicipalityRepository;

    public UpdateContactUseCase(
            ContactRepository repository,
            CityMunicipalityRepository cityMunicipalityRepository
    ) {
        this.repository = repository;
        this.cityMunicipalityRepository = cityMunicipalityRepository;
    }

    public ContactResponse execute(UpdateContactCommand command) {
        var entity = repository.findById(command.id())
                .orElseThrow(() -> new ContactNotFoundApplicationException(command.id().value().toString()));

        entity.update(
                command.fullName(),
                command.email(),
                command.notes(),
                command.cityId(),
                command.createdBy(),
                command.updatedBy()
        );

        var updated = repository.save(entity);
        return new ContactResponse(
                updated.id().value(),
                updated.fullName(),
                updated.email(),
                updated.notes(),
                updated.cityId(),
                updated.cityId() != null ? cityMunicipalityRepository.findById(new com.backintro.domain.citymunicipality.model.valueobject.CityMunicipalityId(updated.cityId())).map(c -> c.name()).orElse(null) : null,
                updated.createdBy(),
                updated.updatedBy(),
                null,
                null
        );
    }
}