package com.backintro.application.diagnosticsystem.usecase;

import java.time.LocalDateTime;

import com.backintro.application.diagnosticsystem.exception.DiagnosticSystemNotFoundApplicationException;
import com.backintro.domain.diagnosticsystem.event.DiagnosticSystemDeletedEvent;
import com.backintro.domain.diagnosticsystem.model.valueobject.DiagnosticSystemId;
import com.backintro.domain.diagnosticsystem.port.repository.DiagnosticSystemRepository;

public class DeleteDiagnosticSystemUseCase {

    private final DiagnosticSystemRepository repository;

    public DeleteDiagnosticSystemUseCase(
            DiagnosticSystemRepository repository
    ) {
        this.repository = repository;
    }

    public DiagnosticSystemDeletedEvent execute(
            DiagnosticSystemId id
    ) {

        var entity =
                repository.findById(id)
                        .orElseThrow(() ->
                                new DiagnosticSystemNotFoundApplicationException(
                                        id.value().toString()
                                )
                        );

        repository.delete(entity);

        return new DiagnosticSystemDeletedEvent(
                id,
                LocalDateTime.now()
        );
    }
}