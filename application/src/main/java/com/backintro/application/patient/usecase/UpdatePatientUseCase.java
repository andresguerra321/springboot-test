package com.backintro.application.patient.usecase;

import com.backintro.application.patient.command.UpdatePatientCommand;
import com.backintro.application.patient.dto.PatientResponse;
import com.backintro.application.patient.exception.PatientNotFoundApplicationException;
import com.backintro.domain.patient.port.repository.PatientRepository;
import com.backintro.domain.documenttype.port.repository.DocumentTypeRepository;
import com.backintro.domain.gender.port.repository.GenderRepository;
import com.backintro.domain.citymunicipality.port.repository.CityMunicipalityRepository;

public class UpdatePatientUseCase {
    private final PatientRepository repository;
    private final DocumentTypeRepository documentTypeRepository;
    private final GenderRepository genderRepository;
    private final CityMunicipalityRepository cityMunicipalityRepository;

    public UpdatePatientUseCase(
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

    public PatientResponse execute(UpdatePatientCommand command) {
        var entity = repository.findById(command.id())
                .orElseThrow(() -> new PatientNotFoundApplicationException(command.id().value().toString()));

        entity.update(
                command.documentTypeId(),
                command.documentNumber(),
                command.firstName(),
                command.middleName(),
                command.lastName(),
                command.secondLastName(),
                command.birthDate(),
                command.biologicalSexId(),
                command.genderIdentity(),
                command.email(),
                command.phone(),
                command.address(),
                command.cityId(),
                command.createdBy(),
                command.updatedBy()
        );

        var updated = repository.save(entity);
        return new PatientResponse(
                updated.id().value(),
                updated.documentTypeId(),
                documentTypeRepository.findById(new com.backintro.domain.documenttype.model.valueobject.DocumentTypeId(updated.documentTypeId())).map(c -> c.name()).orElse(null),
                updated.documentNumber(),
                updated.firstName(),
                updated.middleName(),
                updated.lastName(),
                updated.secondLastName(),
                updated.birthDate(),
                updated.biologicalSexId(),
                genderRepository.findById(new com.backintro.domain.gender.model.valueobject.GenderId(updated.biologicalSexId())).map(c -> c.description()).orElse(null),
                updated.genderIdentity(),
                updated.genderIdentity() != null ? genderRepository.findById(new com.backintro.domain.gender.model.valueobject.GenderId(updated.genderIdentity())).map(c -> c.description()).orElse(null) : null,
                updated.email(),
                updated.phone(),
                updated.address(),
                updated.active(),
                updated.cityId(),
                updated.cityId() != null ? cityMunicipalityRepository.findById(new com.backintro.domain.citymunicipality.model.valueobject.CityMunicipalityId(updated.cityId())).map(c -> c.name()).orElse(null) : null,
                updated.createdBy(),
                updated.updatedBy(),
                updated.createdAt(),
                updated.updatedAt()
        );
    }
}