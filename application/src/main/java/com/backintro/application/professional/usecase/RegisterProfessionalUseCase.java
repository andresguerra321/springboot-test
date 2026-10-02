package com.backintro.application.professional.usecase;

import com.backintro.application.professional.command.RegisterProfessionalCommand;
import com.backintro.application.professional.dto.ProfessionalResponse;
import com.backintro.domain.professional.model.aggregate.Professional;
import com.backintro.domain.professional.port.repository.ProfessionalRepository;
import com.backintro.domain.documenttype.port.repository.DocumentTypeRepository;
import com.backintro.domain.professionaltype.port.repository.ProfessionalTypeRepository;
import com.backintro.domain.citymunicipality.port.repository.CityMunicipalityRepository;

public class RegisterProfessionalUseCase {
    private final ProfessionalRepository repository;
    private final DocumentTypeRepository documentTypeRepository;
    private final ProfessionalTypeRepository professionalTypeRepository;
    private final CityMunicipalityRepository cityMunicipalityRepository;

    public RegisterProfessionalUseCase(
            ProfessionalRepository repository,
            DocumentTypeRepository documentTypeRepository,
            ProfessionalTypeRepository professionalTypeRepository,
            CityMunicipalityRepository cityMunicipalityRepository
    ) {
        this.repository = repository;
        this.documentTypeRepository = documentTypeRepository;
        this.professionalTypeRepository = professionalTypeRepository;
        this.cityMunicipalityRepository = cityMunicipalityRepository;
    }

    public ProfessionalResponse execute(RegisterProfessionalCommand command) {
        Professional entity = Professional.register(
                command.documentTypeId(),
                command.documentNumber(),
                command.firstName(),
                command.lastName(),
                command.professionalTypeId(),
                command.licenseNumber(),
                command.cityId()
        );
        Professional saved = repository.save(entity);
        return new ProfessionalResponse(
                saved.id().value(),
                saved.documentTypeId(),
                documentTypeRepository.findById(new com.backintro.domain.documenttype.model.valueobject.DocumentTypeId(saved.documentTypeId())).map(c -> c.name()).orElse(null),
                saved.documentNumber(),
                saved.firstName(),
                saved.lastName(),
                saved.professionalTypeId(),
                professionalTypeRepository.findById(new com.backintro.domain.professionaltype.model.valueobject.ProfessionalTypeId(saved.professionalTypeId())).map(c -> c.name()).orElse(null),
                saved.licenseNumber(),
                saved.cityId(),
                saved.cityId() != null ? cityMunicipalityRepository.findById(new com.backintro.domain.citymunicipality.model.valueobject.CityMunicipalityId(saved.cityId())).map(c -> c.name()).orElse(null) : null,
                saved.active(),
                null,
                null
        );
    }
}