package com.backintro.application.professionalstudy.usecase;

import com.backintro.application.professionalstudy.command.RegisterProfessionalStudyCommand;
import com.backintro.application.professionalstudy.dto.ProfessionalStudyResponse;
import com.backintro.domain.professionalstudy.model.aggregate.ProfessionalStudy;
import com.backintro.domain.professionalstudy.port.repository.ProfessionalStudyRepository;
import com.backintro.domain.study.port.repository.StudyRepository;
import com.backintro.domain.professional.port.repository.ProfessionalRepository;
import com.backintro.domain.country.port.repository.CountryRepository;

public class RegisterProfessionalStudyUseCase {
    private final ProfessionalStudyRepository repository;
    private final StudyRepository studyRepository;
    private final ProfessionalRepository professionalRepository;
    private final CountryRepository countryRepository;

    public RegisterProfessionalStudyUseCase(
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

    public ProfessionalStudyResponse execute(RegisterProfessionalStudyCommand command) {
        ProfessionalStudy entity = ProfessionalStudy.register(
                command.studyId(),
                command.professionalId(),
                command.title(),
                command.university(),
                command.valid(),
                command.resolutionNumber(),
                command.countryId()
        );
        ProfessionalStudy saved = repository.save(entity);
        return new ProfessionalStudyResponse(
                saved.id().value(),
                saved.studyId(),
                studyRepository.findById(new com.backintro.domain.study.model.valueobject.StudyId(saved.studyId())).map(c -> c.name()).orElse(null),
                saved.professionalId(),
                professionalRepository.findById(new com.backintro.domain.professional.model.valueobject.ProfessionalId(saved.professionalId())).map(c -> c.firstName() + " " + c.lastName()).orElse(null),
                saved.title(),
                saved.university(),
                saved.valid(),
                saved.resolutionNumber(),
                saved.countryId(),
                saved.countryId() != null ? countryRepository.findById(new com.backintro.domain.country.model.valueobject.CountryId(saved.countryId())).map(c -> c.name()).orElse(null) : null,
                null,
                null
        );
    }
}