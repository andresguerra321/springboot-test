package com.backintro.application.diagnosticsystem.command;

import java.util.Objects;

public record RegisterDiagnosticSystemCommand(
        String code,
        String name,
        String version
) {

    public RegisterDiagnosticSystemCommand {
        Objects.requireNonNull(code, "code must not be null");
        Objects.requireNonNull(name, "name must not be null");
    }
}