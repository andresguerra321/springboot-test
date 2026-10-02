package com.backintro.application.clinicalrecord.usecase;

import com.backintro.application.clinicalrecord.command.RegisterClinicalRecordCommand;
import com.backintro.application.clinicalrecord.dto.ClinicalRecordResponse;
import com.backintro.domain.clinicalrecord.model.aggregate.ClinicalRecord;
import com.backintro.domain.clinicalrecord.port.repository.ClinicalRecordRepository;
import com.backintro.domain.patient.port.repository.PatientRepository;
import com.backintro.domain.clinicalrecordstatus.port.repository.ClinicalRecordStatusRepository;

public class RegisterClinicalRecordUseCase {
    private final ClinicalRecordRepository repository;
    private final PatientRepository patientRepository;
    private final ClinicalRecordStatusRepository clinicalRecordStatusRepository;

    public RegisterClinicalRecordUseCase(
            ClinicalRecordRepository repository,
            PatientRepository patientRepository,
            ClinicalRecordStatusRepository clinicalRecordStatusRepository
    ) {
        this.repository = repository;
        this.patientRepository = patientRepository;
        this.clinicalRecordStatusRepository = clinicalRecordStatusRepository;
    }

    public ClinicalRecordResponse execute(RegisterClinicalRecordCommand command) {
        ClinicalRecord entity = ClinicalRecord.register(
                command.patientId(),
                command.creationDate(),
                command.recordNumber(),
                command.openedAt(),
                command.closedAt(),
                command.statusId(),
                command.createdBy()
        );
        ClinicalRecord saved = repository.save(entity);
        return new ClinicalRecordResponse(
                saved.id().value(),
                saved.patientId(),
                patientRepository.findById(new com.backintro.domain.patient.model.valueobject.PatientId(saved.patientId())).map(c -> c.firstName() + " " + c.lastName()).orElse(null),
                saved.creationDate(),
                saved.recordNumber(),
                saved.openedAt(),
                saved.closedAt(),
                saved.statusId(),
                clinicalRecordStatusRepository.findById(new com.backintro.domain.clinicalrecordstatus.model.valueobject.ClinicalRecordStatusId(saved.statusId())).map(c -> c.name()).orElse(null),
                saved.createdBy(),
                null
        );
    }
}