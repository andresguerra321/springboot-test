package com.backintro.application.professional.usecase;

import com.backintro.application.professional.command.UpdateProfessionalCommand;
import com.backintro.application.professional.dto.ProfessionalResponse;
import com.backintro.application.professional.exception.ProfessionalNotFoundApplicationException;
import com.backintro.domain.professional.port.repository.ProfessionalRepository;
import com.backintro.domain.documenttype.port.repository.DocumentTypeRepository;
import com.backintro.domain.professionaltype.port.repository.ProfessionalTypeRepository;
import com.backintro.domain.citymunicipality.port.repository.CityMunicipalityRepository;

public class UpdateProfessionalUseCase {
    private final ProfessionalRepository repository;
    private final DocumentTypeRepository documentTypeRepository;
    private final ProfessionalTypeRepository professionalTypeRepository;
    private final CityMunicipalityRepository cityMunicipalityRepository;

    public UpdateProfessionalUseCase(
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

    public ProfessionalResponse execute(UpdateProfessionalCommand command) {
        var entity = repository.findById(command.id())
                .orElseThrow(() -> new ProfessionalNotFoundApplicationException(command.id().value().toString()));

        entity.update(
                command.documentTypeId(),
                command.documentNumber(),
                command.firstName(),
                command.lastName(),
                command.professionalTypeId(),
                command.licenseNumber(),
                command.cityId()
        );

        var updated = repository.save(entity);
        return new ProfessionalResponse(
                updated.id().value(),
                updated.documentTypeId(),
                documentTypeRepository.findById(new com.backintro.domain.documenttype.model.valueobject.DocumentTypeId(updated.documentTypeId())).map(c -> c.name()).orElse(null),
                updated.documentNumber(),
                updated.firstName(),
                updated.lastName(),
                updated.professionalTypeId(),
                professionalTypeRepository.findById(new com.backintro.domain.professionaltype.model.valueobject.ProfessionalTypeId(updated.professionalTypeId())).map(c -> c.name()).orElse(null),
                updated.licenseNumber(),
                updated.cityId(),
                updated.cityId() != null ? cityMunicipalityRepository.findById(new com.backintro.domain.citymunicipality.model.valueobject.CityMunicipalityId(updated.cityId())).map(c -> c.name()).orElse(null) : null,
                updated.active(),
                null,
                null
        );
    }
}