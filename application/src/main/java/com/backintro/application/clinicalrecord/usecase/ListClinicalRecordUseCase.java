package com.backintro.application.clinicalrecord.usecase;

import java.util.List;

import com.backintro.application.clinicalrecord.dto.ClinicalRecordResponse;
import com.backintro.domain.clinicalrecord.port.repository.ClinicalRecordRepository;
import com.backintro.domain.patient.port.repository.PatientRepository;
import com.backintro.domain.clinicalrecordstatus.port.repository.ClinicalRecordStatusRepository;

public class ListClinicalRecordUseCase {
    private final ClinicalRecordRepository repository;
    private final PatientRepository patientRepository;
    private final ClinicalRecordStatusRepository clinicalRecordStatusRepository;

    public ListClinicalRecordUseCase(
            ClinicalRecordRepository repository,
            PatientRepository patientRepository,
            ClinicalRecordStatusRepository clinicalRecordStatusRepository
    ) {
        this.repository = repository;
        this.patientRepository = patientRepository;
        this.clinicalRecordStatusRepository = clinicalRecordStatusRepository;
    }

    public List<ClinicalRecordResponse> execute() {
        return repository.findAll()
                .stream()
                .map(entity -> new ClinicalRecordResponse(
                entity.id().value(),
                entity.patientId(),
                patientRepository.findById(new com.backintro.domain.patient.model.valueobject.PatientId(entity.patientId())).map(c -> c.firstName() + " " + c.lastName()).orElse(null),
                entity.creationDate(),
                entity.recordNumber(),
                entity.openedAt(),
                entity.closedAt(),
                entity.statusId(),
                clinicalRecordStatusRepository.findById(new com.backintro.domain.clinicalrecordstatus.model.valueobject.ClinicalRecordStatusId(entity.statusId())).map(c -> c.name()).orElse(null),
                entity.createdBy(),
                null
                ))
                .toList();
    }
}