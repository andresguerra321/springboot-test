package com.backintro.application.clinicalrecord.usecase;

import java.time.LocalDateTime;

import com.backintro.application.clinicalrecord.exception.ClinicalRecordNotFoundApplicationException;
import com.backintro.domain.clinicalrecord.event.ClinicalRecordDeletedEvent;
import com.backintro.domain.clinicalrecord.model.valueobject.ClinicalRecordId;
import com.backintro.domain.clinicalrecord.port.repository.ClinicalRecordRepository;

public class DeleteClinicalRecordUseCase {
    private final ClinicalRecordRepository repository;

    public DeleteClinicalRecordUseCase(ClinicalRecordRepository repository) {
        this.repository = repository;
    }

    public ClinicalRecordDeletedEvent execute(ClinicalRecordId id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new ClinicalRecordNotFoundApplicationException(id.value().toString()));
        repository.delete(entity);
        return new ClinicalRecordDeletedEvent(id, LocalDateTime.now());
    }
}