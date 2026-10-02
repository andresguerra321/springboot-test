package com.backintro.application.professionalstudy.usecase;

import com.backintro.application.professionalstudy.dto.ProfessionalStudyResponse;
import com.backintro.application.professionalstudy.exception.ProfessionalStudyNotFoundApplicationException;
import com.backintro.domain.professionalstudy.model.valueobject.ProfessionalStudyId;
import com.backintro.domain.professionalstudy.port.repository.ProfessionalStudyRepository;
import com.backintro.domain.study.port.repository.StudyRepository;
import com.backintro.domain.professional.port.repository.ProfessionalRepository;
import com.backintro.domain.country.port.repository.CountryRepository;

public class GetProfessionalStudyByIdUseCase {
    private final ProfessionalStudyRepository repository;
    private final StudyRepository studyRepository;
    private final ProfessionalRepository professionalRepository;
    private final CountryRepository countryRepository;

    public GetProfessionalStudyByIdUseCase(
            ProfessionalStudyRepository repository,
            StudyRepository studyRepository,
            ProfessionalRepository professionalRepository,
            CountryRepository countryRepository
    ) {
        this.repository = repository;
        this.studyRepository = studyRepository;
        this.professionalRepository = professionalRepository;
        this.countryRepository = countryRepository;
    }

    public ProfessionalStudyResponse execute(ProfessionalStudyId id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new ProfessionalStudyNotFoundApplicationException(id.value().toString()));
        return new ProfessionalStudyResponse(
                entity.id().value(),
                entity.studyId(),
                studyRepository.findById(new com.backintro.domain.study.model.valueobject.StudyId(entity.studyId())).map(c -> c.name()).orElse(null),
                entity.professionalId(),
                professionalRepository.findById(new com.backintro.domain.professional.model.valueobject.ProfessionalId(entity.professionalId())).map(c -> c.firstName() + " " + c.lastName()).orElse(null),
                entity.title(),
                entity.university(),
                entity.valid(),
                entity.resolutionNumber(),
                entity.countryId(),
                entity.countryId() != null ? countryRepository.findById(new com.backintro.domain.country.model.valueobject.CountryId(entity.countryId())).map(c -> c.name()).orElse(null) : null,
                null,
                null
        );
    }
}