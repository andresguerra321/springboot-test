package com.backintro.application.treatmentstatus.command;

import java.util.Objects;

public record RegisterTreatmentStatusCommand(
        String code,
        String name,
        String description
) {

    public RegisterTreatmentStatusCommand {
        Objects.requireNonNull(code, "code must not be null");
        Objects.requireNonNull(name, "name must not be null");
    }
}