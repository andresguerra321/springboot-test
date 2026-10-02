package com.backintro.application.patient.usecase;

import java.util.List;

import com.backintro.application.patient.dto.PatientResponse;
import com.backintro.domain.patient.port.repository.PatientRepository;
import com.backintro.domain.documenttype.port.repository.DocumentTypeRepository;
import com.backintro.domain.gender.port.repository.GenderRepository;
import com.backintro.domain.citymunicipality.port.repository.CityMunicipalityRepository;

public class ListPatientUseCase {
    private final PatientRepository repository;
    private final DocumentTypeRepository documentTypeRepository;
    private final GenderRepository genderRepository;
    private final CityMunicipalityRepository cityMunicipalityRepository;

    public ListPatientUseCase(
            PatientRepository repository,
            DocumentTypeRepository documentTypeRepository,
            GenderRepository genderRepository,
            CityMunicipalityRepository cityMunicipalityRepository
    ) {
        this.repository = repository;
        this.documentTypeRepository = documentTypeRepository;
        this.genderRepository = genderRepository;
        this.cityMunicipalityRepository = cityMunicipalityRepository;
    }

    public List<PatientResponse> execute() {
        return repository.findAll()
                .stream()
                .map(entity -> new PatientResponse(
                entity.id().value(),
                entity.documentTypeId(),
                documentTypeRepository.findById(new com.backintro.domain.documenttype.model.valueobject.DocumentTypeId(entity.documentTypeId())).map(c -> c.name()).orElse(null),
                entity.documentNumber(),
                entity.firstName(),
                entity.middleName(),
                entity.lastName(),
                entity.secondLastName(),
                entity.birthDate(),
                entity.biologicalSexId(),
                genderRepository.findById(new com.backintro.domain.gender.model.valueobject.GenderId(entity.biologicalSexId())).map(c -> c.name()).orElse(null),
                entity.genderIdentity(),
                entity.genderIdentity() != null ? genderRepository.findById(new com.backintro.domain.gender.model.valueobject.GenderId(entity.genderIdentity())).map(c -> c.name()).orElse(null) : null,
                entity.email(),
                entity.phone(),
                entity.address(),
                entity.active(),
                entity.cityId(),
                entity.cityId() != null ? cityMunicipalityRepository.findById(new com.backintro.domain.citymunicipality.model.valueobject.CityMunicipalityId(entity.cityId())).map(c -> c.nameCity()).orElse(null) : null,
                entity.createdBy(),
                entity.updatedBy(),
                null,
                null
                ))
                .toList();
    }
}