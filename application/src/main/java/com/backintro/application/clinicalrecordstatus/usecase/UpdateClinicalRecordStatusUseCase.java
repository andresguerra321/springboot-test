package com.backintro.application.clinicalrecordstatus.usecase;

import com.backintro.application.clinicalrecordstatus.command.UpdateClinicalRecordStatusCommand;
import com.backintro.application.clinicalrecordstatus.dto.ClinicalRecordStatusResponse;
import com.backintro.application.clinicalrecordstatus.exception.ClinicalRecordStatusNotFoundApplicationException;
import com.backintro.domain.clinicalrecordstatus.port.repository.ClinicalRecordStatusRepository;

public class UpdateClinicalRecordStatusUseCase {

    private final ClinicalRecordStatusRepository repository;

    public UpdateClinicalRecordStatusUseCase(
            ClinicalRecordStatusRepository repository
    ) {
        this.repository = repository;
    }

    public ClinicalRecordStatusResponse execute(
            UpdateClinicalRecordStatusCommand command
    ) {

        var entity =
                repository.findById(command.id())
                        .orElseThrow(() ->
                                new ClinicalRecordStatusNotFoundApplicationException(
                                        command.id()
                                                .value()
                                                .toString()
                                )
                        );

        entity.update(
                command.code(),
                command.name()
        );

        var updated =
                repository.save(entity);

        return new ClinicalRecordStatusResponse(
                updated.id().value(),
                updated.code(),
                updated.name(),
                updated.active(),
                null,
                null
        );
    }
}