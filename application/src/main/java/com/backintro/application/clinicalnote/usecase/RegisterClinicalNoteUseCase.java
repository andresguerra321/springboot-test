package com.backintro.application.clinicalnote.usecase;

import com.backintro.application.clinicalnote.command.RegisterClinicalNoteCommand;
import com.backintro.application.clinicalnote.dto.ClinicalNoteResponse;
import com.backintro.domain.clinicalnote.model.aggregate.ClinicalNote;
import com.backintro.domain.clinicalnote.port.repository.ClinicalNoteRepository;
import com.backintro.domain.professional.port.repository.ProfessionalRepository;

public class RegisterClinicalNoteUseCase {
    private final ClinicalNoteRepository repository;
    private final ProfessionalRepository professionalRepository;

    public RegisterClinicalNoteUseCase(
            ClinicalNoteRepository repository,
            ProfessionalRepository professionalRepository
    ) {
        this.repository = repository;
        this.professionalRepository = professionalRepository;
    }

    public ClinicalNoteResponse execute(RegisterClinicalNoteCommand command) {
        ClinicalNote entity = ClinicalNote.register(
                command.encounterId(),
                command.professionalId(),
                command.subjective(),
                command.objective(),
                command.assessment(),
                command.plan(),
                command.additionalNotes(),
                command.signedAt()
        );
        ClinicalNote saved = repository.save(entity);
        return new ClinicalNoteResponse(
                saved.id().value(),
                saved.encounterId(),
                saved.professionalId(),
                professionalRepository.findById(new com.backintro.domain.professional.model.valueobject.ProfessionalId(saved.professionalId())).map(c -> c.firstName() + " " + c.lastName()).orElse(null),
                saved.subjective(),
                saved.objective(),
                saved.assessment(),
                saved.plan(),
                saved.additionalNotes(),
                saved.signedAt(),
                null,
                null
        );
    }
}