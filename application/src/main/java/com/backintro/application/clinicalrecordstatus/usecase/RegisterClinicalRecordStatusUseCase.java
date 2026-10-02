package com.backintro.application.clinicalrecordstatus.usecase;

import com.backintro.application.clinicalrecordstatus.command.RegisterClinicalRecordStatusCommand;
import com.backintro.application.clinicalrecordstatus.dto.ClinicalRecordStatusResponse;
import com.backintro.domain.clinicalrecordstatus.model.aggregate.ClinicalRecordStatus;
import com.backintro.domain.clinicalrecordstatus.port.repository.ClinicalRecordStatusRepository;

public class RegisterClinicalRecordStatusUseCase {

    private final ClinicalRecordStatusRepository repository;

    public RegisterClinicalRecordStatusUseCase(
            ClinicalRecordStatusRepository repository
    ) {
        this.repository = repository;
    }

    public ClinicalRecordStatusResponse execute(
            RegisterClinicalRecordStatusCommand command
    ) {

        ClinicalRecordStatus entity = ClinicalRecordStatus.register(
                command.code(),
                command.name()
        );

        ClinicalRecordStatus saved =
                repository.save(entity);

        return new ClinicalRecordStatusResponse(
                saved.id().value(),
                saved.code(),
                saved.name(),
                saved.active(),
                null,
                null
        );
    }
}