package com.backintro.application.clinicalnote.usecase;

import java.time.LocalDateTime;

import com.backintro.application.clinicalnote.exception.ClinicalNoteNotFoundApplicationException;
import com.backintro.domain.clinicalnote.event.ClinicalNoteDeletedEvent;
import com.backintro.domain.clinicalnote.model.valueobject.ClinicalNoteId;
import com.backintro.domain.clinicalnote.port.repository.ClinicalNoteRepository;

public class DeleteClinicalNoteUseCase {
    private final ClinicalNoteRepository repository;

    public DeleteClinicalNoteUseCase(ClinicalNoteRepository repository) {
        this.repository = repository;
    }

    public ClinicalNoteDeletedEvent execute(ClinicalNoteId id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new ClinicalNoteNotFoundApplicationException(id.value().toString()));
        repository.delete(entity);
        return new ClinicalNoteDeletedEvent(id, LocalDateTime.now());
    }
}