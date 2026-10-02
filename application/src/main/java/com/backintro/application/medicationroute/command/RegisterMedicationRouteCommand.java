package com.backintro.application.medicationroute.command;

import java.util.Objects;

public record RegisterMedicationRouteCommand(
        String code,
        String name
) {

    public RegisterMedicationRouteCommand {
        Objects.requireNonNull(code, "code must not be null");
        Objects.requireNonNull(name, "name must not be null");
    }
}