package com.backintro.application.professional.usecase;

import java.util.List;

import com.backintro.application.professional.dto.ProfessionalResponse;
import com.backintro.domain.professional.port.repository.ProfessionalRepository;
import com.backintro.domain.documenttype.port.repository.DocumentTypeRepository;
import com.backintro.domain.professionaltype.port.repository.ProfessionalTypeRepository;
import com.backintro.domain.citymunicipality.port.repository.CityMunicipalityRepository;

public class ListProfessionalUseCase {
    private final ProfessionalRepository repository;
    private final DocumentTypeRepository documentTypeRepository;
    private final ProfessionalTypeRepository professionalTypeRepository;
    private final CityMunicipalityRepository cityMunicipalityRepository;

    public ListProfessionalUseCase(
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

    public List<ProfessionalResponse> execute() {
        return repository.findAll()
                .stream()
                .map(entity -> new ProfessionalResponse(
                entity.id().value(),
                entity.documentTypeId(),
                documentTypeRepository.findById(new com.backintro.domain.documenttype.model.valueobject.DocumentTypeId(entity.documentTypeId())).map(c -> c.name()).orElse(null),
                entity.documentNumber(),
                entity.firstName(),
                entity.lastName(),
                entity.professionalTypeId(),
                professionalTypeRepository.findById(new com.backintro.domain.professionaltype.model.valueobject.ProfessionalTypeId(entity.professionalTypeId())).map(c -> c.name()).orElse(null),
                entity.licenseNumber(),
                entity.cityId(),
                entity.cityId() != null ? cityMunicipalityRepository.findById(new com.backintro.domain.citymunicipality.model.valueobject.CityMunicipalityId(entity.cityId())).map(c -> c.name()).orElse(null) : null,
                entity.active(),
                null,
                null
                ))
                .toList();
    }
}