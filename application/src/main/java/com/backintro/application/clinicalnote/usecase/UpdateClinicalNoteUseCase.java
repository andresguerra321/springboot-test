package com.backintro.application.clinicalnote.usecase;

import com.backintro.application.clinicalnote.command.UpdateClinicalNoteCommand;
import com.backintro.application.clinicalnote.dto.ClinicalNoteResponse;
import com.backintro.application.clinicalnote.exception.ClinicalNoteNotFoundApplicationException;
import com.backintro.domain.clinicalnote.port.repository.ClinicalNoteRepository;
import com.backintro.domain.professional.port.repository.ProfessionalRepository;

public class UpdateClinicalNoteUseCase {
    private final ClinicalNoteRepository repository;
    private final ProfessionalRepository professionalRepository;

    public UpdateClinicalNoteUseCase(
            ClinicalNoteRepository repository,
            ProfessionalRepository professionalRepository
    ) {
        this.repository = repository;
        this.professionalRepository = professionalRepository;
    }

    public ClinicalNoteResponse execute(UpdateClinicalNoteCommand command) {
        var entity = repository.findById(command.id())
                .orElseThrow(() -> new ClinicalNoteNotFoundApplicationException(command.id().value().toString()));

        entity.update(
                command.encounterId(),
                command.professionalId(),
                command.subjective(),
                command.objective(),
                command.assessment(),
                command.plan(),
                command.additionalNotes(),
                command.signedAt()
        );

        var updated = repository.save(entity);
        return new ClinicalNoteResponse(
                updated.id().value(),
                updated.encounterId(),
                updated.professionalId(),
                professionalRepository.findById(new com.backintro.domain.professional.model.valueobject.ProfessionalId(updated.professionalId())).map(c -> c.firstName() + " " + c.lastName()).orElse(null),
                updated.subjective(),
                updated.objective(),
                updated.assessment(),
                updated.plan(),
                updated.additionalNotes(),
                updated.signedAt(),
                null,
                null
        );
    }
}