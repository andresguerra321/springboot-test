package com.backintro.application.professionalstudy.usecase;

import java.util.List;

import com.backintro.application.professionalstudy.dto.ProfessionalStudyResponse;
import com.backintro.domain.professionalstudy.port.repository.ProfessionalStudyRepository;
import com.backintro.domain.study.port.repository.StudyRepository;
import com.backintro.domain.professional.port.repository.ProfessionalRepository;
import com.backintro.domain.country.port.repository.CountryRepository;

public class ListProfessionalStudyUseCase {
    private final ProfessionalStudyRepository repository;
    private final StudyRepository studyRepository;
    private final ProfessionalRepository professionalRepository;
    private final CountryRepository countryRepository;

    public ListProfessionalStudyUseCase(
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

    public List<ProfessionalStudyResponse> execute() {
        return repository.findAll()
                .stream()
                .map(entity -> new ProfessionalStudyResponse(
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
                ))
                .toList();
    }
}