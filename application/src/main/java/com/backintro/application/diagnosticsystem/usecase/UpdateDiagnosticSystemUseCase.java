package com.backintro.application.diagnosticsystem.usecase;

import com.backintro.application.diagnosticsystem.command.UpdateDiagnosticSystemCommand;
import com.backintro.application.diagnosticsystem.dto.DiagnosticSystemResponse;
import com.backintro.application.diagnosticsystem.exception.DiagnosticSystemNotFoundApplicationException;
import com.backintro.domain.diagnosticsystem.port.repository.DiagnosticSystemRepository;

public class UpdateDiagnosticSystemUseCase {

    private final DiagnosticSystemRepository repository;

    public UpdateDiagnosticSystemUseCase(
            DiagnosticSystemRepository repository
    ) {
        this.repository = repository;
    }

    public DiagnosticSystemResponse execute(
            UpdateDiagnosticSystemCommand command
    ) {

        var entity =
                repository.findById(command.id())
                        .orElseThrow(() ->
                                new DiagnosticSystemNotFoundApplicationException(
                                        command.id()
                                                .value()
                                                .toString()
                                )
                        );

        entity.update(
                command.code(),
                command.name(),
                command.version()
        );

        var updated =
                repository.save(entity);

        return new DiagnosticSystemResponse(
                updated.id().value(),
                updated.code(),
                updated.name(),
                updated.active(),
                updated.version(),
                null,
                null
        );
    }
}