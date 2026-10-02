package com.backintro.application.clinicalrecord.usecase;

import com.backintro.application.clinicalrecord.command.UpdateClinicalRecordCommand;
import com.backintro.application.clinicalrecord.dto.ClinicalRecordResponse;
import com.backintro.application.clinicalrecord.exception.ClinicalRecordNotFoundApplicationException;
import com.backintro.domain.clinicalrecord.port.repository.ClinicalRecordRepository;
import com.backintro.domain.patient.port.repository.PatientRepository;
import com.backintro.domain.clinicalrecordstatus.port.repository.ClinicalRecordStatusRepository;

public class UpdateClinicalRecordUseCase {
    private final ClinicalRecordRepository repository;
    private final PatientRepository patientRepository;
    private final ClinicalRecordStatusRepository clinicalRecordStatusRepository;

    public UpdateClinicalRecordUseCase(
            ClinicalRecordRepository repository,
            PatientRepository patientRepository,
            ClinicalRecordStatusRepository clinicalRecordStatusRepository
    ) {
        this.repository = repository;
        this.patientRepository = patientRepository;
        this.clinicalRecordStatusRepository = clinicalRecordStatusRepository;
    }

    public ClinicalRecordResponse execute(UpdateClinicalRecordCommand command) {
        var entity = repository.findById(command.id())
                .orElseThrow(() -> new ClinicalRecordNotFoundApplicationException(command.id().value().toString()));

        entity.update(
                command.patientId(),
                command.creationDate(),
                command.recordNumber(),
                command.openedAt(),
                command.closedAt(),
                command.statusId(),
                command.createdBy()
        );

        var updated = repository.save(entity);
        return new ClinicalRecordResponse(
                updated.id().value(),
                updated.patientId(),
                patientRepository.findById(new com.backintro.domain.patient.model.valueobject.PatientId(updated.patientId())).map(c -> c.firstName() + " " + c.lastName()).orElse(null),
                updated.creationDate(),
                updated.recordNumber(),
                updated.openedAt(),
                updated.closedAt(),
                updated.statusId(),
                clinicalRecordStatusRepository.findById(new com.backintro.domain.clinicalrecordstatus.model.valueobject.ClinicalRecordStatusId(updated.statusId())).map(c -> c.name()).orElse(null),
                updated.createdBy(),
                null
        );
    }
}