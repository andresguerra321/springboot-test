package com.backintro.application.clinicalnote.usecase;

import com.backintro.application.clinicalnote.dto.ClinicalNoteResponse;
import com.backintro.application.clinicalnote.exception.ClinicalNoteNotFoundApplicationException;
import com.backintro.domain.clinicalnote.model.valueobject.ClinicalNoteId;
import com.backintro.domain.clinicalnote.port.repository.ClinicalNoteRepository;
import com.backintro.domain.professional.port.repository.ProfessionalRepository;

public class GetClinicalNoteByIdUseCase {
    private final ClinicalNoteRepository repository;
    private final ProfessionalRepository professionalRepository;

    public GetClinicalNoteByIdUseCase(
            ClinicalNoteRepository repository,
            ProfessionalRepository professionalRepository
    ) {
        this.repository = repository;
        this.professionalRepository = professionalRepository;
    }

    public ClinicalNoteResponse execute(ClinicalNoteId id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new ClinicalNoteNotFoundApplicationException(id.value().toString()));
        return new ClinicalNoteResponse(
                entity.id().value(),
                entity.encounterId(),
                entity.professionalId(),
                professionalRepository.findById(new com.backintro.domain.professional.model.valueobject.ProfessionalId(entity.professionalId())).map(c -> c.firstName() + " " + c.lastName()).orElse(null),
                entity.subjective(),
                entity.objective(),
                entity.assessment(),
                entity.plan(),
                entity.additionalNotes(),
                entity.signedAt(),
                null,
                null
        );
    }
}