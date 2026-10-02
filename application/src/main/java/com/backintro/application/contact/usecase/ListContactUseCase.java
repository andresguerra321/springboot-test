package com.backintro.application.contact.usecase;

import java.util.List;

import com.backintro.application.contact.dto.ContactResponse;
import com.backintro.domain.contact.port.repository.ContactRepository;
import com.backintro.domain.citymunicipality.port.repository.CityMunicipalityRepository;

public class ListContactUseCase {
    private final ContactRepository repository;
    private final CityMunicipalityRepository cityMunicipalityRepository;

    public ListContactUseCase(
            ContactRepository repository,
            CityMunicipalityRepository cityMunicipalityRepository
    ) {
        this.repository = repository;
        this.cityMunicipalityRepository = cityMunicipalityRepository;
    }

    public List<ContactResponse> execute() {
        return repository.findAll()
                .stream()
                .map(entity -> new ContactResponse(
                entity.id().value(),
                entity.fullName(),
                entity.email(),
                entity.notes(),
                entity.cityId(),
                entity.cityId() != null ? cityMunicipalityRepository.findById(new com.backintro.domain.citymunicipality.model.valueobject.CityMunicipalityId(entity.cityId())).map(c -> c.name()).orElse(null) : null,
                entity.createdBy(),
                entity.updatedBy(),
                null,
                null
                ))
                .toList();
    }
}