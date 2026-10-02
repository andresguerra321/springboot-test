package com.backintro.application.diagnosticsystem.usecase;

import com.backintro.application.diagnosticsystem.dto.DiagnosticSystemResponse;
import com.backintro.application.diagnosticsystem.exception.DiagnosticSystemNotFoundApplicationException;
import com.backintro.domain.diagnosticsystem.model.valueobject.DiagnosticSystemId;
import com.backintro.domain.diagnosticsystem.port.repository.DiagnosticSystemRepository;

public class GetDiagnosticSystemByIdUseCase {

    private final DiagnosticSystemRepository repository;

    public GetDiagnosticSystemByIdUseCase(
            DiagnosticSystemRepository repository
    ) {
        this.repository = repository;
    }

    public DiagnosticSystemResponse execute(
            DiagnosticSystemId id
    ) {

        var entity =
                repository.findById(id)
                        .orElseThrow(() ->
                                new DiagnosticSystemNotFoundApplicationException(
                                        id.value().toString()
                                )
                        );

        return new DiagnosticSystemResponse(
                entity.id().value(),
                entity.code(),
                entity.name(),
                entity.active(),
                entity.version(),
                null,
                null
        );
    }
}