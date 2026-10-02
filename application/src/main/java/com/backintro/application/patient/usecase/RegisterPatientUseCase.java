package com.backintro.application.patient.usecase;

import com.backintro.application.patient.command.RegisterPatientCommand;
import com.backintro.application.patient.dto.PatientResponse;
import com.backintro.domain.patient.model.aggregate.Patient;
import com.backintro.domain.patient.port.repository.PatientRepository;
import com.backintro.domain.documenttype.port.repository.DocumentTypeRepository;
import com.backintro.domain.gender.port.repository.GenderRepository;
import com.backintro.domain.citymunicipality.port.repository.CityMunicipalityRepository;

public class RegisterPatientUseCase {
    private final PatientRepository repository;
    private final DocumentTypeRepository documentTypeRepository;
    private final GenderRepository genderRepository;
    private final CityMunicipalityRepository cityMunicipalityRepository;

    public RegisterPatientUseCase(
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

    public PatientResponse execute(RegisterPatientCommand command) {
        Patient entity = Patient.register(
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
        Patient saved = repository.save(entity);
        return new PatientResponse(
                saved.id().value(),
                saved.documentTypeId(),
                documentTypeRepository.findById(new com.backintro.domain.documenttype.model.valueobject.DocumentTypeId(saved.documentTypeId())).map(c -> c.name()).orElse(null),
                saved.documentNumber(),
                saved.firstName(),
                saved.middleName(),
                saved.lastName(),
                saved.secondLastName(),
                saved.birthDate(),
                saved.biologicalSexId(),
                genderRepository.findById(new com.backintro.domain.gender.model.valueobject.GenderId(saved.biologicalSexId())).map(c -> c.name()).orElse(null),
                saved.genderIdentity(),
                saved.genderIdentity() != null ? genderRepository.findById(new com.backintro.domain.gender.model.valueobject.GenderId(saved.genderIdentity())).map(c -> c.name()).orElse(null) : null,
                saved.email(),
                saved.phone(),
                saved.address(),
                saved.active(),
                saved.cityId(),
                saved.cityId() != null ? cityMunicipalityRepository.findById(new com.backintro.domain.citymunicipality.model.valueobject.CityMunicipalityId(saved.cityId())).map(c -> c.nameCity()).orElse(null) : null,
                saved.createdBy(),
                saved.updatedBy(),
                null,
                null
        );
    }
}