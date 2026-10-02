package com.backintro.application.clinicalnote.usecase;

import java.util.List;

import com.backintro.application.clinicalnote.dto.ClinicalNoteResponse;
import com.backintro.domain.clinicalnote.port.repository.ClinicalNoteRepository;
import com.backintro.domain.professional.port.repository.ProfessionalRepository;

public class ListClinicalNoteUseCase {
    private final ClinicalNoteRepository repository;
    private final ProfessionalRepository professionalRepository;

    public ListClinicalNoteUseCase(
            ClinicalNoteRepository repository,
            ProfessionalRepository professionalRepository
    ) {
        this.repository = repository;
        this.professionalRepository = professionalRepository;
    }

    public List<ClinicalNoteResponse> execute() {
        return repository.findAll()
                .stream()
                .map(entity -> new ClinicalNoteResponse(
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
                ))
                .toList();
    }
}