package com.backintro.application.professionalstudy.usecase;

import com.backintro.application.professionalstudy.command.UpdateProfessionalStudyCommand;
import com.backintro.application.professionalstudy.dto.ProfessionalStudyResponse;
import com.backintro.application.professionalstudy.exception.ProfessionalStudyNotFoundApplicationException;
import com.backintro.domain.professionalstudy.port.repository.ProfessionalStudyRepository;
import com.backintro.domain.study.port.repository.StudyRepository;
import com.backintro.domain.professional.port.repository.ProfessionalRepository;
import com.backintro.domain.country.port.repository.CountryRepository;

public class UpdateProfessionalStudyUseCase {
    private final ProfessionalStudyRepository repository;
    private final StudyRepository studyRepository;
    private final ProfessionalRepository professionalRepository;
    private final CountryRepository countryRepository;

    public UpdateProfessionalStudyUseCase(
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

    public ProfessionalStudyResponse execute(UpdateProfessionalStudyCommand command) {
        var entity = repository.findById(command.id())
                .orElseThrow(() -> new ProfessionalStudyNotFoundApplicationException(command.id().value().toString()));

        entity.update(
                command.studyId(),
                command.professionalId(),
                command.title(),
                command.university(),
                command.valid(),
                command.resolutionNumber(),
                command.countryId()
        );

        var updated = repository.save(entity);
        return new ProfessionalStudyResponse(
                updated.id().value(),
                updated.studyId(),
                studyRepository.findById(new com.backintro.domain.study.model.valueobject.StudyId(updated.studyId())).map(c -> c.name()).orElse(null),
                updated.professionalId(),
                professionalRepository.findById(new com.backintro.domain.professional.model.valueobject.ProfessionalId(updated.professionalId())).map(c -> c.firstName() + " " + c.lastName()).orElse(null),
                updated.title(),
                updated.university(),
                updated.valid(),
                updated.resolutionNumber(),
                updated.countryId(),
                updated.countryId() != null ? countryRepository.findById(new com.backintro.domain.country.model.valueobject.CountryId(updated.countryId())).map(c -> c.name()).orElse(null) : null,
                null,
                null
        );
    }
}